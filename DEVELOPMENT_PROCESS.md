# MyBookCatalog Development Process

## 1. Requirement Analysis
The goal was to create a mobile application named "MyBookCatalog" that displays a list of books and shows detailed information upon selection. The app also required testing, debugging, and simulation of release/payment features.

## 2. Design Phase
- **UI Design:** Used a `ListView` for the main screen and a `ScrollView` with `TextViews` for the details screen. A custom adapter was designed to show both Title and Author in the list for better UX.
- **Data Model:** Created a `Book` class to hold title, author, genre, and description.

## 3. Implementation
- **MainActivity:** Manages the book list and navigation.
- **BookDetailsActivity:** Displays specific book details and handles the simulated Mobile Money API interaction.
- **BookAdapter:** Custom layout provider for the ListView items.

## 4. Testing & Debugging
- **Functional Testing:** Unit tests were written for the `Book` model.
- **Compatibility:** Edge-to-edge support was added for modern Android devices.
- **Logging:** Implemented Logcat tracking to monitor user navigation and potential errors.

## 5. Deployment Preparation
- Updated versioning in Gradle.
- Created store listing documentation.
- Simulated the end-to-end user purchase flow using Mobile Money.
