# Bridge Pattern – Shakllar va Ranglar

Ushbu loyiha **Bridge (Ko‘prik) Dizayn Pattern** ni oddiy grafik domen orqali namoyish etadi: **Shakllar** va **Ranglar**.

Bridge patternning asosiy maqsadi — **abstraksiyani uning implementatsiyasidan ajratish**, shunda ularning ikkalasi ham bir-biridan mustaqil ravishda o‘zgarishi mumkin bo‘ladi. Ushbu misolda:

* *Shakllar* — **Abstraksiya**
* *Ranglar* — **Implementatsiya**

---

## 📐 Yechilayotgan Muammo

Bridge pattern ishlatilmasa, shakl va rang kombinatsiyalari juda ko‘p sinflar paydo bo‘lishiga olib keladi, masalan:

* `RedCircle`, `GreenCircle`, `BlueCircle`
* `RedSquare`, `GreenSquare`, `BlueSquare`
* va hokazo

Bridge pattern esa buni oldini olib, quyidagilarni ajratadi:

* **Shakl nima ekanligi**
* **Shakl qanday rangda bo‘lishi**

---

## 🧱 Loyiha Tuzilishi

```
Canvas
 ├── Shape                (Abstraksiya)
 │    ├── Circle           (Kengaytirilgan Abstraksiya)
 │    ├── Square           (Kengaytirilgan Abstraksiya)
 │    └── Triangle         (Kengaytirilgan Abstraksiya)
 │
 └── ColorShape            (Implementator)
      ├── RedColorShape    (Aniq Implementator)
      ├── GreenColorShape  (Aniq Implementator)
      └── BlueColorShape   (Aniq Implementator)
```

---

## 🎯 Bridge Pattern Rollari

### Abstraksiya

**`Shape`**

* Shakllar uchun umumiy interfeysni belgilaydi
* Ichida `ColorShape` ga bo‘lgan havolani saqlaydi
* Rang bilan bog‘liq vazifalarni implementatsiyaga topshiradi

### Kengaytirilgan Abstraksiyalar

* **`Circle`**
* **`Square`**
* **`Triangle`**

Ular `Shape` dan meros olib, shaklga xos bo‘lgan xatti-harakatlarni amalga oshiradi va rangdan mustaqil bo‘lib qoladi.

---

### Implementator

**`ColorShape`**

* Rang berish uchun umumiy interfeysni belgilaydi
* Muayyan shakllar haqida hech qanday ma’lumotga ega emas

### Aniq Implementatorlar

* **`RedColorShape`**
* **`GreenColorShape`**
* **`BlueColorShape`**

Har bir sinf rang berishning alohida implementatsiyasini ta’minlaydi va istalgan shakl bilan birga ishlatilishi mumkin.

---

## 🖼️ Client (Mijoz)

**`Canvas`**

* Client rolini bajaradi
* Shakllarni yaratadi va ularga ranglarni biriktiradi
* Shakl va ranglarni dinamik tarzda birlashtirish mumkinligini ko‘rsatadi

---

## 🔗 Bridge Qanday Ishlaydi

Konseptual ko‘rinishi:

```
Shape ------------------> ColorShape
  |                          |
Circle                   RedColorShape
Square                   GreenColorShape
Triangle                 BlueColorShape
```

* Shakllar ranglar bilan kompozitsiya orqali bog‘lanadi
* Shakl va ranglar mustaqil ravishda kengaytiriladi

---

## ✅ Ushbu Dizaynning Afzalliklari

* Sinflar sonining keskin ko‘payib ketishini oldini oladi
* Merosxo‘rlik o‘rniga kompozitsiyadan foydalanadi
* Kengaytirish va qo‘llab-quvvatlashni osonlashtiradi
* Implementatsiyani runtime vaqtida almashtirish imkonini beradi

---

## 🚀 Foydalanish Misoli (Kontseptual)

```java
ColorShape red = new RedColorShape();
Shape circle = new Circle(red);
circle.draw();
```

Bu misolda **qizil rangli doira** yaratiladi va buning uchun alohida `RedCircle` sinfi kerak bo‘lmaydi.

---

## 📚 O‘xshash Patternlar

* **Strategy Pattern** — tuzilishi o‘xshash, ammo maqsadi boshqa
* **Abstract Factory** — ko‘pincha Bridge bilan adashtiriladi

---

## 📝 Xulosa

Ushbu loyiha **Bridge Dizayn Pattern** ning aniq va tushunarli namunasi bo‘lib, abstraksiya (Shakllar) va implementatsiya (Ranglar) ni ajratish orqali moslashuvchan va kengaytiriladigan dizaynni namoyish etadi.

---

Yaxshi kod yozing! 🎨📐
