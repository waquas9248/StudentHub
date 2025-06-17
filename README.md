# Student Hub

## Description
Student Hub is designed to support students studying abroad by providing a platform for networking, community building, and local recommendations. The app allows users to connect with peers who share a similar cultural background, join interest-based groups, and build friendships to support each other. It also facilitates community building through organized events and educational programs where users can share their experiences and engage in meaningful interactions.

## Features
- Domain-restricted through university login
- Networking opportunities
-	Community Building
-	Local Recommendations
-	Academic and Professional Support

## Tech Stack
* **Backend:** Spring Boot (Java)
* **Frontend:** React (JavaScript/TypeScript)
* **Database:** PostgreSQL
* **Authentication:** Azure Active Directory (AAD) OAuth2


## Prerequisites

Before you get started, make sure you have the following installed on your machine:

* **Java Development Kit (JDK) 17 or higher:**
    * Download from: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/install/) (e.g., AdoptOpenJDK, Amazon Corretto, Eclipse Temurin).
    * Verify installation by running:
        ```bash
        java -version
        javac -version
        ```

* **Apache Maven 3.6.0 or higher:**
    * Download from: [Maven Downloads](https://maven.apache.org/download.cgi)
    * Follow the installation instructions for your operating system.
    * Verify installation by running:
        ```bash
        mvn -v
        ```

* **Node.js 18.x or higher & npm (Node Package Manager) 8.x or higher:**
    * Download from: [Node.js Downloads](https://nodejs.org/en/download/) (npm is included with Node.js).
    * Verify installation by running:
        ```bash
        node -v
        npm -v
        ```

* **PostgreSQL Database Server:**
    * Download from: [PostgreSQL Downloads](https://www.postgresql.org/download/)
    * Follow the installation instructions for your operating system. Ensure the PostgreSQL server is running after installation.

* **Git:**
    * Download from: [Git Downloads](https://git-scm.com/downloads)
    * Verify installation by running:
        ```bash
        git --version
        ```

---

## Backend Setup (Spring Boot)

### Database Setup (PostgreSQL)

The backend connects to a PostgreSQL database.

1.  **Start your PostgreSQL server.**
2.  **Create a database named `studenthub`:**
    * Open your PostgreSQL client (e.g., `psql` command line, DBeaver, pgAdmin).
    * Log in as a superuser (e.g., `postgres`).
    * Execute the following SQL command:
        ```sql
        CREATE DATABASE studenthub;
        ```
    * Ensure your `postgres` user (or another user you configure) has access to this database. The default `application.properties` assumes the user `postgres` with a password.

### Azure AD Configuration

Your Spring Boot backend uses Azure Active Directory for authentication. You'll need to set specific environment variables with your Azure AD application details.

**Important:** These environment variables **must** be set in the terminal session or IDE run configuration *before* you launch the Spring Boot application. Changes made via Windows System Properties often don't apply immediately to running or newly opened terminal sessions.

1.  **Retrieve Azure AD Application Details:**
    * Log in to the [Azure Portal](https://portal.azure.com/).
    * Navigate to **Azure Active Directory** > **App registrations**.
    * Find your registered "StudentHub" application (or create a new one).
    * Note down the following:
        * **Application (client) ID:** This is your `AD_STUDENTHUB_CLIENT_ID`.
        * **Directory (tenant) ID:** This is your `AD_TENANT_ID`.
        * **Client Secret:** Go to "Certificates & secrets", create a "New client secret", and **copy its value immediately** as it will not be shown again. This is your `AD_CLIENT_SECRET`.

2.  **Configure Redirect URI:**
    * In your Azure AD App Registration, go to "Authentication".
    * Add `http://localhost:8080/login/oauth2/code/azure` as a "Redirect URI" of type "Web".

3.  **Configure API Permissions:**
    * In your Azure AD App Registration, go to "API permissions".
    * Add "Microsoft Graph" > "Delegated permissions" > `User.Read`.
    * If applicable, ensure "Grant admin consent for [Your Tenant Name]" is clicked.

4.  **Set Environment Variables:**
    Set these variables in the terminal session where you will run your Spring Boot application or directly in your IDE's run configuration.

    * **For PowerShell (Windows):**
        ```powershell
        $env:AD_STUDENTHUB_CLIENT_ID="[YOUR_CORRECT_CLIENT_ID]"
        $env:AD_CLIENT_SECRET="[YOUR_CORRECT_SECRET]"
        $env:AD_TENANT_ID="[YOUR_AZURE_AD_TENANT_ID]"
        $env:POSTGRES_PASSWORD="[YOUR_POSTGRES_PASSWORD]" # If your postgres user has a password
        ```
    * **For Command Prompt (Windows):**
        ```cmd
        set AD_STUDENTHUB_CLIENT_ID="[YOUR_CORRECT_CLIENT_ID]"
        set AD_CLIENT_SECRET="[YOUR_CORRECT_SECRET]"
        set AD_TENANT_ID="[YOUR_AZURE_AD_TENANT_ID]"
        set POSTGRES_PASSWORD="[YOUR_POSTGRES_PASSWORD]"
        ```
    * **For Git Bash / WSL / Linux / macOS:**
        ```bash
        export AD_STUDENTHUB_CLIENT_ID="[YOUR_CORRECT_CLIENT_ID]"
        export AD_CLIENT_SECRET="[YOUR_CORRECT_SECRET]"
        export AD_TENANT_ID="[YOUR_AZURE_AD_TENANT_ID]"
        export POSTGRES_PASSWORD="[YOUR_POSTGRES_PASSWORD]"
        ```
    * **If running from an IDE (IntelliJ, Eclipse, VS Code):** Configure these variables within your Spring Boot application's run configuration settings.

### Running the Backend

1.  **Navigate to the backend project directory:**
    ```bash
    cd path/to/your/studenthub/student-hub-backend
    ```
    (Ensure this is the directory containing `pom.xml`).

2.  **Clean and Build (Optional but Recommended):**
    ```bash
    mvn clean install
    ```
    This compiles the project and downloads dependencies.

3.  **Run the Spring Boot Application:**
    *(Ensure your environment variables from section "Azure AD Configuration" are set in this terminal session or IDE run configuration)*
    ```bash
    mvn spring-boot:run
    ```
    The backend will typically start on `http://localhost:8080`. Look for "Started StudenthubApplication" in the console.

---

## Frontend Setup (React)

### Running the Frontend

1.  **Navigate to the frontend project directory:**
    ```bash
    cd path/to/your/studenthub/student-hub-react
    ```
    (Ensure this is the directory containing `package.json`).

2.  **Install Dependencies:**
    * If you've just cloned the project or it's been a while, you need to install the Node.js dependencies.
    * **If using npm:**
        ```bash
        npm install
        ```
    * **If using Yarn:**
        ```bash
        yarn install
        ```

3.  **Start the React Development Server:**
    * **If using npm:**
        ```bash
        npm start
        ```
    * **If using Yarn:**
        ```bash
        yarn start
        ```
    The React application will typically open in your default web browser at `http://localhost:3000`.

---

## Running Both Applications

To have a fully functional local development environment, you'll need both the backend and frontend running concurrently:

1.  **Open two separate terminal windows** (or use your IDE for the backend and a separate terminal for the frontend).
2.  In the **first terminal**: Follow steps in "Running the Backend".
3.  In the **second terminal**: Follow steps in "Running the Frontend".

Ensure that your frontend (React) is configured to make API requests to `http://localhost:8080` for your backend. Your Spring Boot backend's CORS configuration (usually in a `WebSecurityConfig` or `@CrossOrigin` annotations) should allow requests from `http://localhost:3000`.

---

## Troubleshooting

* **`'react-scripts' is not recognized` (React Frontend):**
    * This almost always means Node.js dependencies are not installed correctly or you're in the wrong directory.
    * **Solution:**
        1.  Ensure you are in the correct `student-hub-react` directory (where `package.json` is).
        2.  Delete the `node_modules` folder: `rmdir /s /q node_modules` (Windows) or `rm -rf node_modules` (macOS/Linux).
        3.  Delete `package-lock.json` (and `yarn.lock` if using Yarn): `del package-lock.json` (Windows) or `rm package-lock.json` (macOS/Linux).
        4.  Clear npm cache: `npm cache clean --force`.
        5.  Run `npm install` (or `yarn install`) again.
        6.  Then `npm start` (or `yarn start`).

* **`AADSTS700016: Application with identifier '...' was not found in the directory '...'` (Azure AD Backend):**
    * This means the Azure AD application registration doesn't exist, is deleted, or the `client-id` being sent is incorrect for that tenant.
    * **Solution:**
        1.  **Verify your Azure AD App Registration:** Go to Azure Portal -> Azure AD -> App registrations. Confirm the `Application (client) ID` matches what you are setting as `AD_STUDENTHUB_CLIENT_ID`. Also, ensure the redirect URIs and API permissions are correctly configured.
        2.  **Verify Environment Variables:** This is the most common cause. Double-check that `AD_STUDENTHUB_CLIENT_ID` and `AD_CLIENT_SECRET` (and `AD_TENANT_ID` if used explicitly) are set correctly in the *exact terminal session or IDE run configuration* before launching your Spring Boot app.
        3.  **Restart the terminal/IDE and the Spring Boot app:** After changing system environment variables or IDE run configs, a full restart of the relevant program is often required.

* **CORS Errors:**
    * If your frontend can't communicate with the backend (e.g., "Cross-Origin Request Blocked"), your Spring Boot backend needs a CORS configuration.
    * **Solution:** In your Spring Boot security configuration (e.g., a class annotated with `@EnableWebSecurity`), ensure you have `http://localhost:3000` allowed as an origin.
        ```java
        // Example CORS configuration in Spring Security (within a @Configuration class that extends WebSecurityConfigurerAdapter or uses SecurityFilterChain)
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.web.SecurityFilterChain;
        import org.springframework.web.cors.CorsConfiguration;
        import org.springframework.web.cors.CorsConfigurationSource;
        import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
        import java.util.Arrays;

        @Configuration
        public class WebSecurityConfig { // Or a class configuring SecurityFilterChain

            @Bean
            public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                    .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Enable CORS using the bean below
                    // ... other security configurations (e.g., OAuth2, CSRF, etc.)
                    .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                    );
                return http.build();
            }

            @Bean
            public CorsConfigurationSource corsConfigurationSource() {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Allow your React app
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                configuration.setAllowedHeaders(Arrays.asList("*")); // Allow all headers
                configuration.setAllowCredentials(true); // Allow cookies/credentials
                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration); // Apply to all paths
                return source;
            }
        }
        ```
        
## Design
1. First cut context model:
![image](https://github.com/user-attachments/assets/f5d5a3ae-f241-492f-842b-cd336c083d59)

2. Requirement Breakdown Structure:
![image](https://github.com/user-attachments/assets/47e27fe4-8083-46a4-9e41-ce5e1eb78585)

3. Database ER Diagram:
![image](https://github.com/user-attachments/assets/5d1b45b3-ba72-434f-88e1-b1b085de5960)

## API
![image](https://github.com/user-attachments/assets/f52489cb-73b6-46bc-a020-a7ce0b6a9dfd)
![image](https://github.com/user-attachments/assets/26b2d2de-ebc5-443d-9333-f0b5078ba8e2)
![image](https://github.com/user-attachments/assets/dac4523b-aff3-44fd-b498-4cc2ac428fc5)
![image](https://github.com/user-attachments/assets/56c48a09-c24d-4485-94c1-de2041abd728)

## Authentication
![image](https://github.com/user-attachments/assets/97b759a3-a38c-47de-877d-901d8f8ae314)
![image](https://github.com/user-attachments/assets/2217c02c-450d-4592-a446-339c45f9e713)


### Authors
* Ashhad Syed
* Aseia Nabi
* Pranitha Bellamkonda

---

## Contact

For any issues or questions, please reach out to the project maintainers.
