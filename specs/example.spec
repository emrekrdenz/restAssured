Specification Heading
=====================

Post
-------------
* Jobject Oluştur
* "id" key ve "1" value degerini JObjecte ekle
* "username" key ve "emre" value degerini JObjecte ekle
* "firstName" key ve "karadeniz" value degerini JObjecte ekle
* "user" apiye "post" methoduyla istek at
* status kod "200" ile ayni mi kontrol et

Get
-------------
*Jobject Oluştur
* "username" key ve "emre" value degerini JObjecte ekle
* "password" key ve "1234" value degerini JObjecte ekle
* "user/login" apiye "get" methoduyla istek at
* status kod "200" ile ayni mi kontrol et
* response "type" alanı "unknown" iceriyor mu kontrol et


Post1
-------------
* "Authorization" key "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTk1MjUzNTYsInVzZXJfbmFtZSI6ImVtcmVrYXJhZGVuaXoiLCJhdXRob3JpdGllcyI6WyJST0xFX0NPTVBBTllfQURNSU4iXSwianRpIjoiMTgyOGE3NzYtYmM1My00YzAyLWFlNTctMjVkNWU0NWFlYTA1IiwiY2xpZW50X2lkIjoidGVzdGluaXVtU3VpdGVUcnVzdGVkQ2xpZW50Iiwic2NvcGUiOlsib3BlbmlkIl19.DvrEvlf7Nh2YQshkmxSxhFSFaS7yZUh45NCgidOWcDa2Lupmqw5h5nDnf5xIDJqh_a2y47NH3dVdCO3f4zyXfwlaYsQv07bhqRgHBYdDMxIVYkDwGcblOBFdR7sJnH2uaOhpdGXx_C9GoShbuNmYnVwWF0Y4hIFAAOqVSeqq73OD9AMlHa0DUOe5qi1LpoVXN_-jK_U4Eq91Bpowg60Sh3pDcd1HtzDzTg1xZvAbvji1Cn8lOeg1_2Suo5mpZofBK8psg_RgQqmGN4Iawvp-ZemPIS62mSqYK2hMEnoplKPIH7MvUiBn2GfApRctVJjraJPTtz4mzy-7ZrmabN_gOQ" value degerini headera ekle
* Jobject Oluştur
* "executions" apiye "get" methoduyla istek at
* status kod "200" ile ayni mi kontrol et