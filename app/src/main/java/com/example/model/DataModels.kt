package com.example.model

data class ServiceCategory(
    val id: String,
    val name: String,
    val iconId: Int? = null // Mocking with Int resource or standard icon
)

data class SalonService(
    val id: String,
    val categoryId: String,
    val name: String,
    val description: String,
    val price: Double,
    val durationMinutes: Int,
    val isPopular: Boolean = false
)

data class Stylist(
    val id: String,
    val name: String,
    val specialty: String,
    val rating: Double,
    val reviewsCount: Int,
    val imageUrl: String = "" 
)

data class TimeSlot(
    val id: String,
    val time: String,
    val isAvailable: Boolean
)

// Mock Data
object MockData {
    val categories = listOf(
        ServiceCategory("1", "Hair"),
        ServiceCategory("2", "Skin"),
        ServiceCategory("3", "Nails"),
        ServiceCategory("4", "Makeup"),
        ServiceCategory("5", "Spa"),
        ServiceCategory("6", "Bridal")
    )

    val services = listOf(
        SalonService("s1", "1", "Signature Haircut", "Includes wash, customized cut, and blow-dry styling.", 55.0, 60, true),
        SalonService("s2", "1", "Balayage Color", "Hand-painted highlights for a natural, sun-kissed look.", 180.0, 180, true),
        SalonService("s3", "2", "Rejuvenating Facial", "Deep cleansing, exfoliation, and hydration mask.", 85.0, 60, true),
        SalonService("s4", "3", "Gel Manicure", "Long-lasting gel polish with cuticle care.", 40.0, 45, false),
        SalonService("s5", "4", "Evening Glam Makeup", "Full face makeup application with lashes.", 90.0, 60, false),
        SalonService("s6", "5", "Hot Stone Massage", "Relieve tension with heated stones and deep tissue techniques.", 110.0, 90, true)
    )

    val stylists = listOf(
        Stylist("st1", "Elena R.", "Master Colorist", 4.9, 124),
        Stylist("st2", "Marcus T.", "Senior Stylist", 4.8, 98),
        Stylist("st3", "Sarah J.", "Skin & Spa Specialist", 5.0, 210),
        Stylist("st4", "Chloe M.", "Nail Artist", 4.7, 56)
    )
    
    val timeSlots = listOf(
        TimeSlot("t1", "09:00 AM", true),
        TimeSlot("t2", "10:00 AM", true),
        TimeSlot("t3", "11:00 AM", false),
        TimeSlot("t4", "01:00 PM", true),
        TimeSlot("t5", "02:00 PM", true),
        TimeSlot("t6", "03:00 PM", false),
        TimeSlot("t7", "04:00 PM", true)
    )
}
