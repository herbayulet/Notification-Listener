# Notification Listener

Notification Listener is an Android application designed to receive all notifications on an Android device. Upon receiving a new notification, it promptly sends it to a Node.js server and stores it in a MySQL database.

## Features

- **Notification Reception**: The application listens for notifications from all apps installed on the device.
- **Real-time Notification Relay**: Any new notification that appears on the device is immediately sent to a Node.js server.
- **Database Integration**: Received notifications are stored in a MySQL database for future reference and analysis.

## Installation

To use the Notification Listener application, follow these steps:

1. Clone this repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the application on your Android device.

## Usage

1. Upon launching the application, grant the necessary permissions for it to access notifications.
2. The application will start listening for notifications in real-time.
3. Whenever a new notification arrives, it will be transmitted to the configured Node.js server.
4. Simultaneously, the notification details will be saved in the MySQL database.

## Configuration

To configure the Notification Listener application, follow these steps:

1. Open the application settings.
2. Specify the Node.js server endpoint where notifications should be sent.
3. Ensure that the Node.js server is configured to handle incoming notifications.
4. Specify MySQL database connection details in the Node.js server configuration.
5. Save the settings.

## Dependencies

The Notification Listener application relies on the following dependencies:

- Android SDK
- [NotificationListenerService](https://developer.android.com/reference/android/service/notification/NotificationListenerService)
- Network communication library (e.g., Retrofit, OkHttp) for sending notifications to the Node.js server.
- Node.js for building the server-side application.
- Express.js or other frameworks for handling HTTP requests in the Node.js server.
- MySQL database for storing notification data.

## File Apk
https://drive.google.com/file/d/1Qp-VJ0CZcFd71JpLhFx-7-hS7MP0yHPm/view?usp=sharing
