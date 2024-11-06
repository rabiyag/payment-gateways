Spring Boot Stripe and PayPal Integration
This project demonstrates integrating Stripe and PayPal payment gateways into a Spring Boot application, allowing for secure online payments and transactions. It serves as a comprehensive example for handling payments in a modern Java-based backend system.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)

## Features
- Stripe Payment Integration: Enables credit card payments with Stripe.
- PayPal Payment Integration: Allows payment processing through PayPal.
- RESTful API Endpoints: APIs for initiating and confirming payments.
- Environment Configuration: Securely manages API keys for Stripe and PayPal.
- Error Handling: Graceful error responses and logging for payment errors.
- Transaction Logs: Records transaction details to the database.

## Technologies Used
- **Spring Boot** (backend framework)
- **MySQL** (database)
- **Payment Gateways** (Stripe, PayPal)
- **Dependencies** (Spring Web, Spring Data JPA, Stripe Java SDK, PayPal SDK)

## Prerequisites
- **JDK 8** or higher
- **MySQl** database
- **Stripe and PayPal API keys** 

## Setup
1. **Clone the repository**:
   ```bash
   git clone https://github.com/rabiyag/spring-boot-stripe-paypal.git
   cd spring-boot-stripe-paypal
   ```


2. **Update application.properties with your API keys and database details:**:
   - Create a new database in PostgreSQL:
    ```properties
    # Stripe Configuration
    stripe.api.key=your_stripe_api_key

    # PayPal Configuration
    paypal.client.id=your_paypal_client_id
    paypal.client.secret=your_paypal_client_secret

    # Database Configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
    ```

3. **Build the project with Maven**:
   ```bash
   mvn clean install
   ```

## Running the Application
1. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

2. **Access the application**:
   - The application will be available at http://localhost:8080:
  

## API Endpoints

1. **Initiate Payment**:
   - Stripe: /api/v1/stripe/payment
   - PayPal: /api/v1/paypal/payment
  

2. **Confirm Payment**:
   - Stripe: /api/v1/stripe/confirm
   - PayPal: /api/v1/paypal/confirm
