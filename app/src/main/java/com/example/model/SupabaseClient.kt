package com.example.model

import com.example.BuildConfig
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.postgrest.from
import kotlinx.serialization.Serializable

@Serializable
data class BookingInsert(
    val service_id: String,
    val stylist_id: String,
    val time_slot: String
)

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = BuildConfig.SUPABASE_URL,
        supabaseKey = BuildConfig.SUPABASE_ANON_KEY
    ) {
        install(Postgrest)
        install(Auth)
    }
    
    suspend fun saveBooking(serviceId: String, stylistId: String, timeSlot: String) {
        client.from("bookings").insert(
            BookingInsert(
                service_id = serviceId,
                stylist_id = stylistId,
                time_slot = timeSlot
            )
        )
    }
}
