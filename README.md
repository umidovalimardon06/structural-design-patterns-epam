# Proxy Design Pattern ishlatilmaganda yuzaga keladigan muammo

## Muammo tavsifi

Ushbu loyihada tasvir (image) fayllarini ko‘rsatish uchun `ImageFile` kabi **og‘ir (heavy) obyektlar** ishlatiladi.
Agar **Proxy Design Pattern** qo‘llanilmasa va `ImageFile` obyektlari **to‘g‘ridan-to‘g‘ri** yaratilsa, tizimda bir nechta muammolar yuzaga keladi.

---

## Proxy ishlatilmagan holatdagi yondashuv

```java
ImageFile image = new ImageFile("image1.jpeg");
image.display();
```

Yuqoridagi yondashuvda har safar:

* yangi obyekt yaratiladi
* rasm diskdan qayta yuklanadi
* tizim resurslari ortiqcha ishlatiladi

---

## Yuzaga keladigan muammolar

### 1) Performance (tezlik) muammosi

* Rasm fayllari katta hajmli bo‘lishi mumkin
* Diskdan o‘qish (I/O operation) sekin jarayon
* Har bir `display()` chaqirig‘ida rasm qayta yuklanadi
* Natijada dastur sekin ishlaydi

### 2) Xotira (Memory) isrofi

* Har safar `new ImageFile()` → yangi obyekt
* RAM ortiqcha band qilinadi
* Garbage Collector tez-tez ishga tushadi
* Katta miqdordagi rasmlar bilan ishlaganda dastur sekinlashadi yoki crash bo‘lish ehtimoli oshadi

### 3) Lazy Loading mavjud emas

* Rasm darhol yuklanadi, hatto foydalanuvchi uni ko‘rmasa ham
* Keraksiz resurs sarfi yuz beradi
* Yuklash vaqtini nazorat qilish imkoni yo‘q

### 4) Kengaytirish va nazorat qilish qiyin

Proxy bo‘lmaganda quyidagi funksiyalarni qo‘shish murakkablashadi:

* rasm yuklashni kechiktirish (delay)
* cache qo‘shish
* access control (ruxsat tekshirish)
* logging/monitoring

---

## Proxy Design Pattern yechimi (qisqacha)

Proxy Pattern **real obyekt (`ImageFile`) bilan mijoz (`Client`) orasiga vositachi (`ImageProxy`) qo‘yadi**.

```java
if (imageFile == null) {
    imageFile = new ImageFile(path);
}
imageFile.display();
```

---

## Proxy ishlatilgandagi afzalliklar

* Rasm **faqat birinchi marta** yuklanadi
* Keyingi chaqiriqlarda qayta yuklanmaydi
* Tizim tezligi oshadi
* Xotira samarali ishlatiladi
* Lazy Loading amalga oshiriladi

---

## Xulosa

❌ Proxy Design Pattern ishlatilmasa:

* Performance pasayadi
* Xotira isrofi yuzaga keladi
* Katta loyihalarda jiddiy muammolar kelib chiqadi

✅ Proxy Design Pattern ishlatilsa:

* Resurslar tejaladi
* Dastur tez va barqaror ishlaydi
* Toza va professional arxitektura ta’minlanadi

---

## Tavsiya

Agar tizimda:

* og‘ir obyektlar (rasm, video, fayl, network resurs)
* ko‘p marotaba chaqiriladigan obyektlar

mavjud bo‘lsa, **Proxy Design Pattern ishlatish qat’iy tavsiya etiladi**.
