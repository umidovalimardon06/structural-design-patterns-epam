# Composite Pattern Implementation - O'zbek tilida

## 📐 Pattern Strukturasi

```
Payee (Interface)
    ├── Manager (Leaf)
    ├── SalesPerson (Leaf)
    └── SalesTeam (Composite)
```

---

## 🔧 Implementation Qadamlari

### 1️⃣ Component Interface - `Payee.java`

```java
public interface Payee {
    void pay(int amount);
}
```

**Vazifasi:** Barcha leaf va composite klasslar uchun umumiy interface.

---

### 2️⃣ Leaf Node - `Manager.java`

```java
public class Manager implements Payee {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println(name + " (Manager) has been paid $" + amount);
    }
}
```

**Xususiyatlari:**
- ✅ `Payee` interface ni implement qiladi
- ✅ Oddiy xodim (leaf node)
- ✅ O'z nomiga pul oladi

---

### 3️⃣ Leaf Node - `SalesPerson.java`

```java
public class SalesPerson implements Payee {
    private String name;
    private Manager manager;

    public SalesPerson(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }

    @Override
    public void pay(int amount) {
        System.out.println(name + " (SalesPerson) has been paid $" + amount);
    }
}
```

**Xususiyatlari:**
- ✅ `Payee` interface ni implement qiladi
- ✅ Oddiy sotuvchi (leaf node)
- ✅ Manager ga bog'langan

---

### 4️⃣ Composite Node - `SalesTeam.java`

```java
import java.util.ArrayList;
import java.util.List;

public class SalesTeam implements Payee {
    private List<Payee> teamMembers = new ArrayList<>();

    public void addMember(Payee payee) {
        teamMembers.add(payee);
    }

    public void removeMember(Payee payee) {
        teamMembers.remove(payee);
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying entire SalesTeam:");
        for (Payee member : teamMembers) {
            member.pay(amount);
        }
    }
}
```

**Muhim o'zgarishlar:**
- ❌ Eski: `addManager()` va `addSalesPerson()` alohida metodlar
- ✅ Yangi: Bitta `addMember(Payee payee)` metodi
- ✅ `List<Payee>` - polymorphic list
- ✅ Har qanday `Payee` turini qabul qiladi

**Afzalliklari:**
- Manager, SalesPerson yoki boshqa SalesTeam qo'shish mumkin
- Daraxt strukturasini yaratish oson
- Yangi Payee turlari uchun kod o'zgartirish shart emas

---

### 5️⃣ Client Code - `ExpensesClient.java`

```java
public class ExpensesClient {

    public static void main(String[] args) {
        // Leaf nodes yaratish
        Manager kamil = new Manager("Kamil");
        SalesPerson bobur = new SalesPerson("Bobur", kamil);
        SalesPerson salima = new SalesPerson("Salima", kamil);

        // Composite node yaratish
        SalesTeam team = new SalesTeam();
        team.addMember(kamil);    // ✅ Umumiy metod
        team.addMember(bobur);    // ✅ Umumiy metod
        team.addMember(salima);   // ✅ Umumiy metod

        // Barcha Payee larni bir xil tarzda to'lash
        payPayee(kamil, 100);     // Individual manager
        payPayee(bobur, 300);     // Individual salesperson
        payPayee(team, 200);      // Butun jamoa
    }

    // ✅ Bitta universal metod
    private static void payPayee(Payee payee, int amount) {
        System.out.println("Expenses have been requested");
        payee.pay(amount);
        System.out.println("Expenses have been paid\n");
    }
}
```

---

## 📊 Output

```
Expenses have been requested
Kamil (Manager) has been paid $100
Expenses have been paid

Expenses have been requested
Bobur (SalesPerson) has been paid $300
Expenses have been paid

Expenses have been requested
Paying entire SalesTeam:
Kamil (Manager) has been paid $200
Bobur (SalesPerson) has been paid $200
Salima (SalesPerson) has been paid $200
Expenses have been paid
```

---

## 🎯 Pattern ning Asosiy Qismlari

| Component | Turi | Vazifasi |
|-----------|------|----------|
| `Payee` | Interface | Umumiy shartnoma |
| `Manager` | Leaf | Oddiy xodim |
| `SalesPerson` | Leaf | Oddiy xodim |
| `SalesTeam` | Composite | Xodimlar guruhi |

---

## ✅ Erishilgan Natijalar

### 1. **Polymorphism**
```java
Payee p1 = new Manager("Ali");
Payee p2 = new SalesPerson("Vali", manager);
Payee p3 = new SalesTeam();

// Hammasi bir xil tarzda ishlatiladi
payPayee(p1, 100);
payPayee(p2, 200);
payPayee(p3, 300);
```

### 2. **Sodda Client Kodi**
- ❌ Avval: 3 ta turli metod
- ✅ Hozir: 1 ta umumiy metod

### 3. **Kengaytirish Qulayligi**
Yangi `Director` klassi qo'shsak:
```java
public class Director implements Payee {
    // Faqat Payee ni implement qiling
}
```
Client kodini o'zgartirish shart emas!

### 4. **Daraxt Strukturasi**
```java
SalesTeam mainTeam = new SalesTeam();
SalesTeam subTeam1 = new SalesTeam();
SalesTeam subTeam2 = new SalesTeam();

mainTeam.addMember(subTeam1);
mainTeam.addMember(subTeam2);
mainTeam.addMember(new Manager("Boss"));

payPayee(mainTeam, 1000); // Butun daraxtga to'lov
```

---

## 🔄 Oldingi Kod bilan Taqqoslash

| Oldingi Yondashuv | Composite Pattern |
|-------------------|-------------------|
| `addManager()` | `addMember(Payee)` |
| `addSalesPerson()` | `addMember(Payee)` |
| `List<Manager>` va `List<SalesPerson>` | `List<Payee>` |
| Type-specific metodlar | Generic metod |
| Kengaytirish qiyin | Oson kengaytirish |

---

## 💡 Qachon Ishlatish Kerak?

Composite Pattern qo'llang, agar:
- ✅ Daraxt strukturasini boshqarish kerak
- ✅ Leaf va composite larni bir xil tarzda ishlating
- ✅ Part-whole (qism-butun) munosabatlar mavjud
- ✅ Rekursiv tuzilmalar bor

**Misollar:**
- Fayl tizimi (File/Folder)
- GUI komponentlar (Button/Panel)
- Tashkilot strukturasi (Xodim/Departament)
- Menyu tizimi (MenuItem/Menu)

---

## 🎓 Xulosa

Composite Pattern sizga imkon beradi:
1. **Bir xillik** - barcha obyektlar bir xil interface orqali
2. **Soddalik** - client kod soddalashadi
3. **Moslashuvchanlik** - oson kengaytirish
4. **Rekursiya** - daraxt strukturalarni boshqarish

Bu pattern **Structural Design Patterns** oilasiga kiradi va murakkab ierarxik tuzilmalarni boshqarishning eng yaxshi usuli hisoblanadi.