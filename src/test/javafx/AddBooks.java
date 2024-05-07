

package test.javafx;
public class AddBooks {
    public BookInventory bookInventory;

    public AddBooks(BookInventory bookInventory) {
        this.bookInventory = bookInventory;
    }

    public void addExampleBooks() {
        // Add 5 example books to each genre
        addFictionBooks();
        addNonFictionBooks();
        addMysteryBooks();
        addScienceFictionBooks();
        addFantasyBooks();
        addRomanceBooks();
        addHorrorBooks();
        addThrillerBooks();
        addBiographyBooks();
        addHistoryBooks();
        addSelfHelpBooks();
        addPoetryBooks();
        addChildrenBooks(); 
    }

    public void addFictionBooks() {
        bookInventory.addBook(new Book(1, "The Great Gatsby", "F. Scott", "Fitzgerald", 12.99, "FICTION", 10));
        bookInventory.addBook(new Book(2, "To Kill a Mockingbird", "Harper", "Lee", 11.50, "FICTION", 15));
        bookInventory.addBook(new Book(3, "1984", "George", "Orwell", 10.75, "FICTION", 20));
        bookInventory.addBook(new Book(4, "The Catcher in the Rye", "J.D.", "Salinger", 9.99, "FICTION", 18));
        bookInventory.addBook(new Book(5, "Brave New World", "Aldous", "Huxley", 11.25, "FICTION", 12));
    }

    public void addNonFictionBooks() {
        bookInventory.addBook(new Book(6, "Sapiens: A Brief History of Humankind", "Yuval Noah", "Harari", 15.75, "NON_FICTION", 20));
        bookInventory.addBook(new Book(7, "Astrophysics for People in a Hurry", "Neil deGrasse", "Tyson", 14.25, "NON_FICTION", 8));
        bookInventory.addBook(new Book(8, "Guns, Germs, and Steel", "Jared", "Diamond", 14.75, "NON_FICTION", 13));
        bookInventory.addBook(new Book(9, "The 7 Habits of Highly Effective People", "Stephen R.", "Covey", 9.95, "NON_FICTION", 6));
        bookInventory.addBook(new Book(10, "The Subtle Art of Not Giving a F*ck", "Mark", "Manson", 12.50, "NON_FICTION", 10));
    }

    private void addMysteryBooks() {
        bookInventory.addBook(new Book(11, "The Da Vinci Code", "Dan", "Brown", 10.99, "MYSTERY", 12));
        bookInventory.addBook(new Book(12, "Gone Girl", "Gillian", "Flynn", 11.75, "MYSTERY", 16));
        bookInventory.addBook(new Book(13, "The Girl with the Dragon Tattoo", "Stieg", "Larsson", 9.95, "MYSTERY", 14));
        bookInventory.addBook(new Book(14, "The Woman in the Window", "A.J.", "Finn", 13.25, "MYSTERY", 8));
        bookInventory.addBook(new Book(15, "The Silent Patient", "Alex", "Michaelides", 12.50, "MYSTERY", 10));
    }

    private void addScienceFictionBooks() {
        bookInventory.addBook(new Book(16, "Dune", "Frank", "Herbert", 9.95, "SCIENCE_FICTION", 5));
        bookInventory.addBook(new Book(17, "The Martian", "Andy", "Weir", 10.50, "SCIENCE_FICTION", 11));
        bookInventory.addBook(new Book(18, "Neuromancer", "William", "Gibson", 11.25, "SCIENCE_FICTION", 7));
        bookInventory.addBook(new Book(19, "Snow Crash", "Neal", "Stephenson", 12.75, "SCIENCE_FICTION", 9));
        bookInventory.addBook(new Book(20, "Ender's Game", "Orson Scott", "Card", 11.99, "SCIENCE_FICTION", 14));
    }

    public void addFantasyBooks() {
        bookInventory.addBook(new Book(101, "The Hobbit", "J.R.R.", "Tolkien", 12.75, "Fantasy", 18));
        bookInventory.addBook(new Book(102, "Harry Potter and the Sorcerer's Stone", "J.K.", "Rowling", 11.50, "Fantasy", 16));
        bookInventory.addBook(new Book(103, "A Game of Thrones", "George R.R.", "Martin", 15.99, "Fantasy", 10));
        bookInventory.addBook(new Book(104, "The Name of the Wind", "Patrick", "Rothfuss", 14.25, "Fantasy", 12));
        bookInventory.addBook(new Book(105, "Mistborn: The Final Empire", "Brandon", "Sanderson", 13.50, "Fantasy", 20));
    }

    public void addRomanceBooks() {
        bookInventory.addBook(new Book(106, "Pride and Prejudice", "Jane", "Austen", 8.99, "Romance", 14));
        bookInventory.addBook(new Book(107, "The Notebook", "Nicholas", "Sparks", 10.25, "Romance", 15));
        bookInventory.addBook(new Book(108, "Me Before You", "Jojo", "Moyes", 11.75, "Romance", 8));
        bookInventory.addBook(new Book(109, "The Fault in Our Stars", "John", "Green", 9.50, "Romance", 11));
        bookInventory.addBook(new Book(110, "Outlander", "Diana", "Gabaldon", 12.99, "Romance", 18));
    }
    
    public void addHorrorBooks() {
        bookInventory.addBook(new Book(111, "It", "Stephen", "King", 13.50, "Horror", 7));
        bookInventory.addBook(new Book(112, "The Shining", "Stephen", "King", 12.25, "Horror", 9));
        bookInventory.addBook(new Book(113, "Dracula", "Bram", "Stoker", 11.99, "Horror", 11));
        bookInventory.addBook(new Book(114, "Pet Sematary", "Stephen", "King", 10.75, "Horror", 8));
        bookInventory.addBook(new Book(115, "The Exorcist", "William Peter", "Blatty", 9.95, "Horror", 6));
    }

    // Method to add example Thriller books
    public void addThrillerBooks() {
        bookInventory.addBook(new Book(116, "The Girl on the Train", "Paula", "Hawkins", 11.25, "Thriller", 11));
        bookInventory.addBook(new Book(117, "Gone Girl", "Gillian", "Flynn", 10.50, "Thriller", 12));
        bookInventory.addBook(new Book(118, "The Da Vinci Code", "Dan", "Brown", 10.99, "Thriller", 10));
        bookInventory.addBook(new Book(119, "The Girl with the Dragon Tattoo", "Stieg", "Larsson", 12.75, "Thriller", 9));
        bookInventory.addBook(new Book(120, "Sharp Objects", "Gillian", "Flynn", 11.75, "Thriller", 7));
    }

    // Method to add example Biography books
    public void addBiographyBooks() {
        bookInventory.addBook(new Book(121, "Steve Jobs", "Walter", "Isaacson", 16.00, "Biography", 9));
        bookInventory.addBook(new Book(122, "Becoming", "Michelle", "Obama", 14.50, "Biography", 11));
        bookInventory.addBook(new Book(123, "Leonardo da Vinci", "Walter", "Isaacson", 17.25, "Biography", 8));
        bookInventory.addBook(new Book(124, "The Diary of a Young Girl", "Anne", "Frank", 9.75, "Biography", 7));
        bookInventory.addBook(new Book(125, "Elon Musk", "Ashlee", "Vance", 13.99, "Biography", 6));
    }

    // Method to add example History books
    public void addHistoryBooks() {
        bookInventory.addBook(new Book(126, "Sapiens: A Brief History of Humankind", "Yuval Noah", "Harari", 15.75, "History", 20));
        bookInventory.addBook(new Book(127, "Guns, Germs, and Steel", "Jared", "Diamond", 14.75, "History", 13));
        bookInventory.addBook(new Book(128, "1491: New Revelations of the Americas Before Columbus", "Charles C.", "Mann", 12.95, "History", 10));
        bookInventory.addBook(new Book(129, "The Rise and Fall of the Third Reich", "William L.", "Shirer", 18.50, "History", 8));
        bookInventory.addBook(new Book(130, "The Civil War: A Narrative", "Shelby", "Foote", 20.25, "History", 12));
    }

    // Method to add example Self-Help books
    public void addSelfHelpBooks() {
        bookInventory.addBook(new Book(131, "The 7 Habits of Highly Effective People", "Stephen R.", "Covey", 9.95, "Self-Help", 6));
        bookInventory.addBook(new Book(132, "Atomic Habits", "James", "Clear", 14.99, "Self-Help", 9));
        bookInventory.addBook(new Book(133, "You Are a Badass", "Jen", "Sincero", 11.25, "Self-Help", 7));
        bookInventory.addBook(new Book(134, "Mindset: The New Psychology of Success", "Carol S.", "Dweck", 12.75, "Self-Help", 11));
        bookInventory.addBook(new Book(135, "The Power of Now", "Eckhart", "Tolle", 10.50, "Self-Help", 8));
    }

    // Method to add example Poetry books
    public void addPoetryBooks() {
        bookInventory.addBook(new Book(136, "Milk and Honey", "Rupi", "Kaur", 7.99, "Poetry", 22));
        bookInventory.addBook(new Book(137, "The Sun and Her Flowers", "Rupi", "Kaur", 8.50, "Poetry", 18));
        bookInventory.addBook(new Book(138, "The Waste Land", "T.S.", "Eliot", 6.75, "Poetry", 13));
        bookInventory.addBook(new Book(139, "Leaves of Grass", "Walt", "Whitman", 9.25, "Poetry", 10));
        bookInventory.addBook(new Book(140, "Selected Poems", "Emily", "Dickinson", 8.99, "Poetry", 15));
    }

    // Method to add example Children's books
    public void addChildrenBooks() {
        bookInventory.addBook(new Book(141, "Harry Potter and the Chamber of Secrets", "J.K.", "Rowling", 12.50, "Children", 20));
        bookInventory.addBook(new Book(142, "Charlotte's Web", "E.B.", "White", 9.75, "Children", 15));
        bookInventory.addBook(new Book(143, "Matilda", "Roald", "Dahl", 8.99, "Children", 18));
        bookInventory.addBook(new Book(144, "The Lion, the Witch and the Wardrobe", "C.S.", "Lewis", 10.25, "Children", 12));
        bookInventory.addBook(new Book(145, "Where the Wild Things Are", "Maurice", "Sendak", 7.50, "Children", 17));
    }

}
