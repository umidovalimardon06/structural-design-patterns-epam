# Decorator Pattern Namunasi

## Tavsif

Bu loyiha **Decorator strukturaviy dizayn patternini** Java dasturlash tilida amalga oshirish namunasini ko'rsatadi. Decorator pattern obyektga qo'shimcha funksiyalarni dinamik ravishda qo'shish imkonini beradi, bunda asosiy klass strukturasini o'zgartirish shart emas.

## Patternning Maqsadi

Decorator pattern obyektni o'rab olib (wrap), unga yangi xatti-harakatlar qo'shish uchun ishlatiladi. Bu yondashuv meros (inheritance) dan foydalanishga nisbatan ko'proq moslashuvchan yechim hisoblanadi.

## Tuzilma

Loyiha quyidagi komponentlardan iborat:

- **Component** (interface) - barcha komponentlar uchun umumiy interfeys
- **Circle** - `Component` interfeysini amalga oshiruvchi konkret klass, doira chizadi
- **ComponentWithRedBorder** - decorator klass, istalgan komponentga qizil rang qo'shadi
- **Canvas** - barcha komponentlarni ekranga chiqaruvchi asosiy sinf

## Ishlash Printsipi

1. `Circle` klassi oddiy qora doira chizadi
2. `ComponentWithRedBorder` decorator klassi mavjud komponentni o'rab olib, unga qizil rang qo'shadi
3. `Canvas` sinfida ikkinchi doira (`circle2`) dekoratorga o'raladi va qizil rangda chiziladi

## Ishga Tushirish
```bash
javac Canvas.java
java Canvas
```

Dastur 3 ta doira chizadi: birinchi va uchinchisi qora rangda, ikkinchisi qizil rangda.

## Afzalliklari

- Obyektlarga dinamik ravishda funksiyalar qo'shish
- Kodni qayta ishlatish
- Single Responsibility printsipiga amal qilish
- Meros ierarxiyasini murakkablashtirishdan qochish