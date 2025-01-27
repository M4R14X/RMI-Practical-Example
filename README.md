# RMI (Remote Method Invocation) in Java
This small project is a practical example of using RMI in Java. It's a preparation for a bigger project comming soon inchaallah.
In this example, the client sends 2 matrices to the server, which calculates their sum and sends the result back to the client.
I have added multithreading so we can run multiple clients.

## Steps to run the project

### Clone the repository
```bash
git clone https://github.com/M4R14X/RMI-Practical-Example.git
```
### Ensure Classes Are Compiled
Open the Command Prompt.
Navigate to the project folder and run:
```bash
javac -d build src/shared/*.java src/server/*.java src/client/*.java
```
### Start the RMI Registry
Open the Command Prompt.
Navigate to the project folder and run:
```bash
start rmiregistry
```
**If an error occurs** stating that the command was not found, check the **Troubleshooting** section of this **README**.

### Run the Server
Open the Command Prompt.
Navigate to the project's folder and run:
```bash
java -cp build server.RMIServer
```
### Run the RMI client
In another Command Prompt, navigate to the project folder and run:
```bash
java -cp build client.RMIClient
```
## Troubleshooting

### Verify JDK Installation
```bash
java -version
```
### Locate rmiregistry
Find the location of the rmiregistry executable:
1. Open the folder where the JDK is installed (e.g., **C:\Program Files\Java\jdk-<version>**).
2. Look for the **bin** folder.
3. Inside the **bin** folder, you should find **rmiregistry.exe**.

### Add JDK bin Folder to PATH
To run rmiregistry from anywhere, add the JDK bin folder to your system's PATH:

#### 1. Open Environment Variables:
Right-click **"This PC"** or **"My Computer"** and choose **Properties**.
Click **Advanced System Settings** > **Environment Variables**.

#### 2. Edit the PATH Variable:
In the **"System variables"** section, find the **Path** variable and click **Edit**.
Click **New**, and add the path to the **bin** folder of your JDK installation (e.g., **C:\Program Files\Java\jdk-<version>\bin**).
Click **OK** to save.

#### 3. Verify Setup:
Close and reopen the **Command Prompt**.
Run:
```bash
rmiregistry
```
If it runs without error, the setup is complete.

#### 4. Check if it's running
Open the Command Prompt and run:
```bash
netstat -a | findstr 1099
```
If you see output like **LISTENING**, it means the **rmiregistry** is running on the default RMI port (1099).
If it’s running, you can proceed to start your RMI server :)
