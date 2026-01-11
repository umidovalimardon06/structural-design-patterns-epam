# Composite Design Pattern - Zarurlik va Muammolar

## 📋 Hozirgi Kodning Muammolari

### 1. **Kod Takrorlanishi (Code Duplication)**

Har bir xodim turi uchun alohida metod yozilgan:

```java
private static void payManager(Manager manager, int amount) {
    System.out.println("Expenses have been requested");
    manager.payExpenses(amount);
    System.out.println("Expenses have been paid\n");
}

private static void paySalesPerson(SalesPerson salesPerson, int amount) {
    System.out.println("Expenses have been requested");
    salesPerson.payExpenses(amount);
    System.out.println("Expenses have been paid\n");
}

private static void paySalesTeam(SalesTeam salesTeam, int amount) {
    System.out.println("Expenses have been requested");
    salesTeam.payExpenses(amount);
    System.out.println("Expenses have been paid\n");
}
```

**Muammo:** Bir xil kod 3 marta takrorlangan. Bu DRY (Don't Repeat Yourself) printsipiga zid.

---

### 2. **Umumiy Interface Yo'qligi**

`Manager`, `SalesPerson` va `SalesTeam` klasslari:
- Bir xil `payExpenses(int amount)` metodiga ega
- Lekin umumiy interface yoki parent class yo'q
- Shuning uchun ularni polymorphic tarzda ishlatib bo'lmaydi

---

### 3. **Client Kodi Murakkablashgan**

```java
payManager(kamil, 100);           // Manager uchun
paySalesPerson(bobur, 300);       // SalesPerson uchun  
paySalesTeam(team, 200);          // SalesTeam uchun
```

**Muammo:** Har bir tur bilan alohida muomala qilish kerak.

---

### 4. **Kengaytirish Qiyinligi**

Yangi xodim turi qo'shsak (masalan, `Director`, `Intern`):

❌ Qilish kerak bo'ladigan ishlar:
- Yangi klass yaratish
- Yangi `payDirector()` metodi yozish
- Client kodini o'zgartirish
- Kod takrorlanishi yana ko'payadi

---

### 5. **Type Safety Yo'qligi**

```java
// Har xil turlarni bir List ga qo'shib bo'lmaydi
List<???> allEmployees = new ArrayList<>();
allEmployees.add(kamil);    // ❌ Manager
allEmployees.add(bobur);    // ❌ SalesPerson  
allEmployees.add(team);     // ❌ SalesTeam
```

---

### 6. **Daraxt Strukturasini Boshqarish Qiyin**

Hozirgi tizim:
```
Manager (Kamil)
    └── SalesPerson (Bobur)
    └── SalesPerson (Salima)
```

**Muammo:** Bu ierarxiyani bir xil tarzda boshqarib bo'lmaydi. Manager ham, SalesPerson ham alohida kod talab qiladi.

---

## ✅ Composite Pattern Yechimi

Composite Pattern qo'llanganda:

### 1. **Bitta Interface**
```java
interface IExpensable {
    void payExpenses(int amount);
}
```

### 2. **Barcha Klasslar Interface Implement Qiladi**
```java
class Manager implements IExpensable { ... }
class SalesPerson implements IExpensable { ... }
class SalesTeam implements IExpensable { ... }
```

### 3. **Bitta Metod Yetarli**
```java
private static void payExpenses(IExpensable expensable, int amount) {
    System.out.println("Expenses have been requested");
    expensable.payExpenses(amount);
    System.out.println("Expenses have been paid\n");
}
```

### 4. **Sodda Client Kodi**
```java
payExpenses(kamil, 100);
payExpenses(bobur, 300);
payExpenses(team, 200);
```

---

## 🎯 Composite Pattern Afzalliklari

| Hozirgi Holat | Composite Pattern bilan |
|---------------|-------------------------|
| ❌ 3 ta alohida metod | ✅ 1 ta umumiy metod |
| ❌ Interface yo'q | ✅ Umumiy interface bor |
| ❌ Kod takrorlanadi | ✅ DRY prinsipi bajariladi |
| ❌ Yangi tur qo'shish qiyin | ✅ Osongina kengaytirish mumkin |
| ❌ Polymorphism ishlamaydi | ✅ To'liq polymorphic yondashuv |

---

## 🌳 Real Hayotiy Misol

**Fayl Tizimi:**
- `File` (oddiy fayl) - leaf node
- `Folder` (papka ichida fayllar va papkalar) - composite node
- Ikkalasi ham `delete()`, `copy()`, `move()` metodlariga ega
- Bir xil interface orqali boshqariladi

**Xuddi shu prinsip Expenses tizimida ham qo'llaniladi:**
- `SalesPerson` - leaf (oddiy xodim)
- `SalesTeam` - composite (ichida bir necha xodimlar)
- Ikkalasi ham `payExpenses()` qiladi

---

## 📊 Xulosa

**Composite Design Pattern** kerak, chunki:

1. **Daraxt strukturasini** sodda boshqarish imkonini beradi
2. **Kod takrorlanishini** kamaytiradi
3. **Polymorphism** dan to'liq foydalanish imkonini beradi
4. **Kengaytirish** ni osonlashtiradi
5. **Client kodni** soddalashtiradi

Bu pattern part-whole (qism-butun) munosabatlarni boshqarishning eng yaxshi usuli hisoblanadi.