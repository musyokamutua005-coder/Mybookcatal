package com.example.mybookcatal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * TASK 1: DEVELOP A MOBILE APPLICATION - MyBookCatalog
 * Displays a list of books and enables viewing details by clicking on a book.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyBookCatalog_Main";
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Starting MyBookCatalog"); // TASK 2.v: Debug tracking
        
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        // TASK 2.iv: Compatibility - Handling window insets for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeBooks();

        ListView listView = findViewById(R.id.bookListView);

        // TASK 2.iii: UI/UX Testing - Using a custom adapter for a professional UI
        BookAdapter adapter = new BookAdapter(this, bookList);
        listView.setAdapter(adapter);

        // TASK 1: Enable detail viewing by clicking on book items
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Book selectedBook = bookList.get(position);
            Log.i(TAG, "User clicked on book: " + selectedBook.getTitle()); // TASK 2.v: Log tracking
            
            Intent intent = new Intent(MainActivity.this, BookDetailsActivity.class);
            intent.putExtra("book", selectedBook);
            startActivity(intent);
        });
    }

    /**
     * Catalog data sourced from the assignment (Pages 3 & 4)
     * Using book cover images from drawable resources.
     */
    private void initializeBooks() {
        Log.d(TAG, "initializeBooks: Loading catalog data");
        bookList = new ArrayList<>();
        
        bookList.add(new Book("The Last Ember", "Daniel Rosh", "Historical Thriller", 
                "A former archaeologist is pulled into a deadly conspiracy when ancient secrets buried beneath Rome resurface.",
                R.drawable.book1_the_last_ember));
        
        bookList.add(new Book("Quantum Mirage", "Lila Chen", "Science Fiction", 
                "In a future where time travel is illegal, a rogue physicist must choose between saving the world or saving her daughter.",
                R.drawable.book2_quantum_mirage));
        
        bookList.add(new Book("Roots & Wings", "Maria Esteban", "Literary Fiction", 
                "A moving generational story of a Cuban-American family searching for identity, belonging, and redemption.",
                R.drawable.book3_roots_wings));
        
        bookList.add(new Book("The Mind Sculptor", "Dr. Evan Shaw", "Psychology / Non-Fiction", 
                "A groundbreaking look at neuroplasticity and how you can rewire your brain for success and happiness.",
                R.drawable.book4_mind_sculptor));
        
        bookList.add(new Book("Inkbound: Chronicles of the Lost Library", "J.R. Faulkner", "Fantasy / Adventure", 
                "A young librarian discovers that ancient books can open portals to other worlds—but not all stories have happy endings.",
                R.drawable.book5_inkbound));
        
        bookList.add(new Book("Startup Savage", "Nicole Vega", "Business / Entrepreneurship", 
                "A brutally honest guide to launching a tech startup in the real world, full of failures, pivots, and unexpected wins.",
                R.drawable.book6_startup_savage));
        
        bookList.add(new Book("Beneath Crimson Skies", "Tomasz Novak", "Historical Fiction / WWII", 
                "The intertwined lives of resistance fighters, spies, and survivors during the Nazi occupation of Warsaw.",
                R.drawable.book7_beneath_crimson));
        
        bookList.add(new Book("The Art of Stillness", "Tara Bell", "Self-Help / Mindfulness", 
                "Learn how to find peace in a chaotic world by mastering the ancient wisdom of stillness.",
                R.drawable.book8_art_of_stillness));
        
        bookList.add(new Book("Neon Ghosts", "Khalid Jones", "Urban Fantasy / Mystery", 
                "A private investigator with the ability to see spirits uncovers a supernatural conspiracy beneath the city's neon lights.",
                R.drawable.book9_neon_ghosts));
        
        bookList.add(new Book("Eat Green, Live Clean", "Dr. Sanjay Patel", "Health & Wellness", 
                "A practical guide to plant-based nutrition and detox living, backed by science and easy recipes.",
                R.drawable.book10_eat_green));

        Log.d(TAG, "initializeBooks: Loaded " + bookList.size() + " books with local covers.");
    }
}
