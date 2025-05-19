Currency Converter Application

Project Description

This is a simple Java console application that converts an amount from one currency to another. The program uses a public online API to get the latest exchange rates.

Features:

1. Takes user input for base currency, target currency, and amount.
2. Fetches real-time exchange rates from an API.
3. Displays the converted amount.
4. Shows a list of some popular currencies.
5. Handles errors like invalid currency codes or connection issues.


Requirements

Java 8 or above installed.
Internet connection is required to access the API.
JSON library (org.json) for parsing API response.


How to Run

1. Compile the program:

javac CurrencyConverterAPI.java


2. Run the program:

java CurrencyConverterAPI


3. Follow instructions on the console:

Enter base currency code (e.g., USD)

Enter target currency code (e.g., INR)

Enter amount to convert




Example

Currency Converter App
Base currency (like USD): USD
Target currency (like INR): INR
Amount: 100

Some available currencies:
USD  INR  EUR  JPY  GBP  AUD  CAD  CNY  SGD  NZD  

Converted: 8240.5 INR

Notes

Use 3-letter ISO currency codes (e.g., USD, INR, EUR).

Make sure you have a working internet connection.

If an invalid currency code is entered, the program will show an error.



---
