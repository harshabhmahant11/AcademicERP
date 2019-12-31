function login() {

    var Url = 'http://localhost:8080/AcademicERP_war/webapi/api/login';
    var data={
        EID:101,
        password:""
    }

    var eid_var = document.getElementById("eid").value;
    var pass_var = document.getElementById("password").value;

    data.EID = eid_var;
    data.password = pass_var;

    if(eid_var=="" || pass_var == "")
    {
        alert("Please enter data!!!");
    }
    else {
        $('#loginWait').show();
        $.post(Url, data, function (data1, status) {
            $('#loginWait').hide();
            if (data1 == "success") {
                location.replace("http://localhost:8080/AcademicERP_war/pages/admin.html")
            } else if (data1 == "notadmin") {
                alert("You are not from Admin Department!!!");
            } else {
                alert("Incorrect username or password!!!");
            }

        });

    }
}