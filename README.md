# Text Encryption and Decryption

A simple text encryption and decryption application with a user-friendly GUI. The application allows users to convert text into an unreadable code and vice versa. It includes features for writing the encrypted or decrypted output to binary or character files.

## Main Class (Main.java)
- **Features**: 
  - Displays welcome message and program description.
  - Main menu for selecting encryption, decryption, or exiting.
  - Utilizes the `Coding` class for text processing.
  - Allows users to choose file input/output or direct input/output.

## File I/O Class (IOFile.java)
- **Features**:
  - Handles binary and character file reading/writing.
  - Provides methods for getting file paths and managing user input errors.

## Text Processing Class (Coding.java)
- **Features**:
  - Processes text to convert it into an unreadable code using a random character set.
  - Supports conversion of the code back to the original text.

## How to Use
1. Run the `main` method in the `Main` class to start the application.
2. Choose between encryption, decryption, or exiting in the main menu.
3. Select file or direct input/output options.
4. Follow on-screen prompts to enter text or file paths.
5. Review the encrypted or decrypted output.