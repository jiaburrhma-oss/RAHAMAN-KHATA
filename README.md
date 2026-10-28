# RAHAMAN KHATA - Native Android Application

Digital shop accounts, customer credit (Udhaar), payments received, expenses, and outstanding balances management app built with **Kotlin** and **Jetpack Compose**.

## Features Included
1. **Dashboard**: Live balances (You'll get / You'll give), today's sales & expenses, recent transactions.
2. **Customer Management**: Add, edit, search, archive customers with phone and addresses.
3. **Customer Ledger**: Automatically calculates running balance. Debit (Credit Given) and Credit (Payment Received) tracking.
4. **Business Expenses**: Track shop expenses categorized by Rent, Utilities, Stock Purchase, Salary, Tea/Refreshment, Transport, etc.
5. **Reports**: Detailed statements, cashflow analytics, and CSV export.
6. **Data & Security**: Room SQLite local persistence, transaction deletion audit trails, and strict accounting balance integrity.
7. **Bilingual Support**: Full English and Hindi (हिंदी) localization.

## Prerequisites
- Android Studio Ladybug (2024.2.1+) or newer
- JDK 17 or higher
- Android SDK 35 (compileSdk 35, minSdk 24)

## How to Build the APK
1. Open Android Studio.
2. Select **File > Open** and choose this project folder.
3. Let Gradle sync project dependencies.
4. To build the Debug APK via command line:
   ```bash
   ./gradlew assembleDebug
   ```
5. The generated APK will be at:
   `app/build/outputs/apk/debug/app-debug.apk`
6. To build the release signed bundle/APK:
   ```bash
   ./gradlew assembleRelease
   ```
