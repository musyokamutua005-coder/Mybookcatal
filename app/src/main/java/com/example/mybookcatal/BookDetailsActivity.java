package com.example.mybookcatal;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BookDetailsActivity extends AppCompatActivity {

    private static final String TAG = "MyBookCatalog_Details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Displaying book details");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_details);

        // Handle window insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.book_details_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Book book = (Book) getIntent().getSerializableExtra("book");

        if (book != null) {
            Log.i(TAG, "Showing details for book: " + book.getTitle());
            ImageView imageCover = findViewById(R.id.detailImage);
            TextView title = findViewById(R.id.detailTitle);
            TextView author = findViewById(R.id.detailAuthor);
            TextView genre = findViewById(R.id.detailGenre);
            TextView description = findViewById(R.id.detailDescription);
            Button btnPayment = findViewById(R.id.btnSimulatePayment);

            title.setText(book.getTitle());
            author.setText("Author: " + book.getAuthor());
            genre.setText("Genre: " + book.getGenre());
            description.setText(book.getDescription());

            // Set the book cover from drawable resources
            imageCover.setImageResource(book.getImageResId());

            btnPayment.setOnClickListener(v -> simulatePayment(book.getTitle()));
        } else {
            Log.e(TAG, "onCreate: No book data received in Intent");
        }
    }

    private void simulatePayment(String bookTitle) {
        Log.d(TAG, "simulatePayment: User initiated payment for " + bookTitle);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mobile Money Payment");
        builder.setMessage("Simulating Mobile Money API integration...\n\nProceed to pay for: " + bookTitle + "?");
        
        builder.setPositiveButton("Pay Now", (dialog, which) -> {
            Log.i(TAG, "simulatePayment: Transaction completed for " + bookTitle);
            Toast.makeText(BookDetailsActivity.this, "Payment Successful via Mobile Money!", Toast.LENGTH_LONG).show();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            Log.d(TAG, "simulatePayment: Transaction cancelled by user");
            dialog.dismiss();
        });

        builder.show();
    }
}
