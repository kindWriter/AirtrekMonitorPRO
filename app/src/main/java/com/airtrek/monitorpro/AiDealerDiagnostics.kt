package com.airtrek.monitorpro

data class AiDealerDiagnostics(
    val engineHealth: Double,
    val transmissionHealth: Double,
    val awdHealth: Double,
    val warnings: List<String>
) {
    companion object {
        fun sample(): AiDealerDiagnostics = AiDealerDiagnostics(
            engineHealth = 91.0,
            transmissionHealth = 88.0,
            awdHealth = 86.0,
            warnings = listOf(
                "Проверьте производительность топливного насоса низкого давления",
                "Обнаружены признаки износа ТНВД GDI",
                "Повышенная детонационная активность",
                "Контролируйте температуру АКПП",
                "Проверить нагрузку генератора"
            )
        )
    }
}
