# Flyweight Design Pattern – Muammo Demonstratsiyasi

## 🧩 Muammo nima?

Ushbu loyihada yo‘l harakati (traffic) simulyatsiyasi yaratilgan. Dastur doimiy ravishda:

- yangi transport vositalarini (`Car` va `Truck`) yaratadi
- ularni xotirada saqlaydi
- va ma’lum vaqtdan keyin o‘chiradi

Muammo shundaki, **har safar yangi obyekt yaratilmoqda**, hattoki u obyektlar:
- bir xil turga ega (`Car` yoki `Truck`)
- bir xil xususiyatlarga ega
- faqat joylashuvi (location) bilan farq qiladi

Bu esa **keraksiz xotira sarfiga** olib keladi.

---

## ⚠️ Muammoning ildizi

Quyidagi kod qismiga e’tibor bering:

```java
if (randInt == 0) {
    vehicle = new Car();
} else {
    vehicle = new Truck();
}
