1. **Configure WebDriver in your application:**

    Ensure that your application is correctly configured to use `ChromeDriver`. You may need to set the path to the `chromedriver` executable in your code:

    ```java
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    WebDriver driver = new ChromeDriver();
    ```

    Replace `"path/to/chromedriver"` with the actual path to your `chromedriver` executable.

2. **Set up environment variables:**

    If your project requires specific environment variables (like API keys or file paths), set them in your operating system or through a `.env` file if supported by your setup.

### Usage

1. **Run the application:**

    Execute the main application class to start the automated process:

    ```bash
    mvn spring-boot:run
    ```

2. **View the output:**

    The application will search for LG soundbars on Amazon India, collect data, sort it by price, and print the results to the console.

### Troubleshooting

- **SessionNotCreatedException:** Ensure that the version of ChromeDriver matches the version of your installed Chrome browser.
- **WebDriverException:** Confirm that the ChromeDriver executable path is correctly set and that it's added to your system's PATH.
- **InvalidArgumentException:** Make sure that the `goog:chromeOptions` capabilities in your WebDriver setup are correctly configured.
