Specification Heading
=====================

//BASE_URLDEKİ TESTİNİUMU AÇARSIN
Post1
-------------
* "Authorization" key "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NjEwNTE2OTcsInVzZXJfbmFtZSI6ImVtcmVrYXJhZGVuaXoiLCJhdXRob3JpdGllcyI6WyJST0xFX0NPTVBBTllfQURNSU4iXSwianRpIjoiZjU0MDJmZjEtZDI0Ni00NzhlLWFjMmMtYjQ0YzFjZDc3YmIyIiwiY2xpZW50X2lkIjoidGVzdGluaXVtU3VpdGVUcnVzdGVkQ2xpZW50Iiwic2NvcGUiOlsib3BlbmlkIl19.gc5LmjDhSI3tlF8sqa4HKohh8e5o4VPg_AP61S7YWE0IZU7hJRy2fXe23flz2HFcBgvoKXxXJaKLqR5IhHv3xdWxUttNlsBgw1cGJSMd8-Zor9owX-wCLTYfRfjcN9pvso-4N2rRfEMFcX1l5gfYGWhqkXXJdHmtUfupvPeFYanlILvjxAhiw3UBW0X9fwyWec-vS8pMO3V0xb2FzEDMAfZZF_40aCBDbNQFT-y00rLo3tZVskDiRThi1hJvYZOiY0fBUS2s84kJuGgoa7e0lJoMdk7kM2a0ZAuaLjhXj00m7t_ki5q-DRA_Zj6P2CxLHN0yglMafCahs6sxU_WuZw" value degerini headera ekle
* Jobject Oluştur
* "executions" apiye "get" methoduyla istek at
* status kod "200" ile ayni mi kontrol et
* response "item_list[0].id" alanı "587548" iceriyor mu kontrol et
* response "item_list[1].id" alanı "587541" iceriyor mu kontrol et
* response "item_list[2].id" alanı "587540" iceriyor mu kontrol et
* response "item_list[2].id" keyinin degerini "itemListID" olarak kaydet


Get1
-------------
* "accept" key "application/json" value degerini headera ekle
* "api_key" key "emre" value degerini headera ekle
* Jobject Oluştur
* "https://petstore.swagger.io/v2/pet/12" apiye "get" methoduyla istek at
* status kod "200" ile ayni mi kontrol et

Post
-------------
* Jobject Oluştur
* "id" key ve "1" value degerini JObjecte ekle
* "username" key ve "emre" value degerini JObjecte ekle
* "firstName" key ve "karadeniz" value degerini JObjecte ekle
* "https://petstore.swagger.io/v2/user" apiye "post" methoduyla istek at
* status kod "200" ile ayni mi kontrol et


JSONN2
------------------
* "emre" keyli "emreKaraddd" degeri hashmap'e ekle
* "emre" json pathindeki requestBodyi hazırla
* "https://reqres.in/api/users" requestBodydeki degerlerle servise "post" methoduyla istek at
