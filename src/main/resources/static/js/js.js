$(document).ready(function () {
    ogrenciGetir();
    islemGetir();

    function ogrenciGetir() {
        $.ajax({
            url: "http://localhost:8080/ogrenci",
            type: "GET",
            datatype: 'json',
            success: function (gelenVeri) {
                $(".ogrenci tbody").empty();
                $.each(gelenVeri, function (i, ogrenci) {
                    $(".ogrenci tbody")
                        .append('<tr> <td>' + ogrenci.ad + '</td><td>' + ogrenci.dogumTarihi + '</td><td>' + ogrenci.yeniMi + '</td></tr>');
                });

            }

        });
    }

    function islemGetir() {
        $.ajax({
            url: "http://localhost:8080/islem",
            type: "GET",
            datatype: 'json',
            success: function (gelenVeri) {
                $(".islem tbody").empty();
                $.each(gelenVeri, function (i, islem) {
                    $(".islem tbody")
                        .append('<tr> <td>' + islem.islemYapanId + '</td><td>' + islem.islemTarihi + '</td><td>' + islem.tutar + '</td></tr>');
                });

            }

        });
    }


    $(".ogrenci button").click(function () {
        var form_data =
            {
                ad: $('#ogrenciAd').val(),
                dogumTarihi: $('#ogrenciDogumTarihi').val(),
            };
        var json_str = JSON.stringify(form_data);
        $.ajax({
            url: "http://localhost:8080/ogrenci",
            type: 'POST',
            contentType: "application/json",
            data: json_str

        });
        ogrenciGetir();
    });
    $(".islem button").click(function () {
        var form_data =
            {
                islemYapanId: parseInt($('#islemYapanId').val()),
                islemTarihi: $('#islemTarihi').val(),
                tutar: parseFloat($('#tutar').val()),
            };
        var json_str = JSON.stringify(form_data);
        $.ajax({
            url: "http://localhost:8080/islem",
            type: 'POST',
            contentType: "application/json",
            data: json_str
        });
        islemGetir();
    })


});