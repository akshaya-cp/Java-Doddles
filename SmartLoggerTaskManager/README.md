# Smart Logger & Task Manager (Stage 1 - Logger Singleton)

## 💡 Why I Built This?
This is my very first Java project while learning OOP concepts.  
I built this **Logger Singleton** to:
- Practice **Java basics (classes, packages, methods)**
- Learn **Singleton Pattern** (ensure only one object across the app)
- Mimic real-world **logging systems** used in software (time-stamped logs, levels like INFO/WARNING/ERROR)

---

## 🚀 Features
- Implements **Singleton Pattern** (only one Logger instance exists globally)
- Prints **time-stamped log messages** with log levels (INFO, WARNING, ERROR)
- Verifies Singleton with **memory hashcodes**
- Beginner-friendly & well-commented for learning purposes

---

## 📸 Sample Output
![Logger Output](docs/logger-output.png)


---

## 🔥 Stage 2: Encapsulated Task Manager
Built a Task Manager to:
- Learn **Encapsulation** (private fields + getters/setters)
- Manage tasks using **ArrayList**
- Log every action using **Logger Singleton**

### Key Files:
- `Task.java` → Encapsulated task model
- `TaskManager.java` → Adds, completes, and displays tasks with logs

## 📸 Sample Output
![Logger Output](docs/Task-Manager.png)


## 🚀 **What’s New in Stage 3?**
✅ Persistent storage using **File I/O**  
✅ Tasks saved in `tasks.txt` and loaded automatically on restart  
✅ Logs written to `logs.txt` with **run-wise headings** (separates logs per application run)  
✅ **Clean data folder** (`/data`) for storing logs and tasks  
✅ Beginner-friendly **minimalistic changes** to learn step-by-step

---

## 📸 Sample Output
![Logger Output](docs/Stage-3(1).png)
![Logger Output](docs/Stage-3(2).png)