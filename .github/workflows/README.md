# Airtrek Monitor PRO v7 ULTRA AI DEALER

Android 11 приложение для Mitsubishi Airtrek 2001 (4G64 GDI, Full Time 4WD, АКПП) с безопасным диагностическим режимом.

## Безопасность
- SAFE MODE всегда включён (только чтение и DTC операции):
  - Mode 01: чтение данных
  - Mode 03: чтение DTC
  - Mode 04: очистка DTC
- Запрещены ECU coding / flashing / EEPROM writing / конфигурационные изменения.

## Возможности
- Foreground Service для постоянной сессии ELM327.
- Каталог 300+ MUT-II параметров.
- Русский дашборд с AI-оценкой узлов (двигатель/АКПП/AWD).
- Кнопки `SCAN ALL ECU` и `CLEAR ERRORS`.

## Сборка APK локально
```bash
./gradlew assembleDebug assembleRelease
```
Готовые APK:
- `app/build/outputs/apk/debug/app-debug.apk`
- `app/build/outputs/apk/release/app-release.apk`

## GitHub Actions
Workflow: `.github/workflows/android.yml`
- Ubuntu latest
- Java 17
- сборка `assembleDebug` и `assembleRelease`
- загрузка артефактов APK
