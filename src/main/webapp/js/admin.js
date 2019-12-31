var global_jd;
var getallDomainUrl;
var oldD_code;

function getAllDomain(url) {
    $('#wait').show();
    $.getJSON(
            url,
            function(jd) {
                $('#wait').hide();
                $('#addmodalbutton').show();
                $('#headLine').show();
                getallDomainUrl = url;
                global_jd = jd;
                document.getElementById("domTable").innerHTML = "";
                var tbl = document.getElementById("domTable");

                var tblBody = document.createElement("tbody");

                var headRow = document.createElement("tr");

                var hcell = document.createElement("th");
                var heading = document.createTextNode("Domain Code");
                hcell.appendChild(heading);
                headRow.appendChild(hcell);

                var hcell = document.createElement("th");
                var heading = document.createTextNode("Domain Name");
                hcell.appendChild(heading);
                headRow.appendChild(hcell);

                var hcell = document.createElement("th");
                var heading = document.createTextNode("Domain Capacity");
                hcell.appendChild(heading);
                headRow.appendChild(hcell);

                var hcell = document.createElement("th");
                var heading = document.createTextNode("Domain Qualification");
                hcell.appendChild(heading);
                headRow.appendChild(hcell);

                var hcell = document.createElement("th");
                var heading = document.createTextNode("Actions");
                hcell.appendChild(heading);
                headRow.appendChild(hcell);


                tblBody.appendChild(headRow);
                // creating all cells
                for (var i = 0; i < jd.length; i++) {
                    // creates a table row
                    var row = document.createElement("tr");

                        // Create a <td> element and a text node, make the text
                        // node the contents of the <td>, and put the <td> at
                        // the end of the table row

                        var cell = document.createElement("td");
                        var cellText = document.createTextNode(jd[i].d_code);
                        cell.appendChild(cellText);
                        row.appendChild(cell);

                        var cell = document.createElement("td");
                        var cellText = document.createTextNode(jd[i].d_name);
                        cell.appendChild(cellText);
                        row.appendChild(cell);

                        var cell = document.createElement("td");
                        var cellText = document.createTextNode(jd[i].d_capacity);
                        cell.appendChild(cellText);
                        row.appendChild(cell);

                        var cell = document.createElement("td");
                        var cellText = document.createTextNode(jd[i].d_qualification);
                        cell.appendChild(cellText);
                        row.appendChild(cell);

                    var s = "<button type=\"button\" class=\"btn btn-primary\"><i class=\"far fa-eye\"></i></button>" +
                        "<button type=\"button\" class=\"btn btn-success\"><i class=\"fas fa-edit\"></i></button>" +
                        "<button type=\"button\" class=\"btn btn-danger\"><i class=\"far fa-trash-alt\"></i></button>";


                        var cell = document.createElement("td");
                        cell.setAttribute("id","action"+i);
                        cell.setAttribute("align","center");




                        var button1 = document.createElement("button");
                        button1.setAttribute("type","button");
                        button1.setAttribute("class","btn btn-primary");
                        button1.setAttribute("onclick","viewFunc("+i+")" );

                        /*hover code*/
                       /* button1.setAttribute("data-toggle","tooltip");
                        button1.setAttribute("data-placement","top");*/
                        button1.setAttribute("data-toggle","modal");
                        button1.setAttribute("data-target","#ViewSModal");
                        button1.setAttribute("title","View Students Enrolled");

                        var button1Inner = document.createElement("i");
                        button1Inner.setAttribute("class", "fa fa-eye");
                        button1Inner.setAttribute("aria-hidden","true");
                        button1.appendChild(button1Inner);
                        cell.appendChild(button1);


                        var button2 = document.createElement("button");
                        button2.setAttribute("type","button");
                        button2.setAttribute("class","btn btn-success");
                        button2.setAttribute("onclick","modifyFunc("+i+")" );
                        button2.setAttribute("data-toggle","modal");
                        button2.setAttribute("data-target","#modifyModal");

                        /*hover code*/
                       // button2.setAttribute("data-toggle","tooltip");
                       // button2.setAttribute("data-placement","top");
                        button2.setAttribute("title","Modify Domain");

                        var button2Inner = document.createElement("i");
                        button2Inner.setAttribute("class", "fa fa-pencil-square-o");
                        button2Inner.setAttribute("aria-hidden","true");
                        button2.appendChild(button2Inner);
                        cell.appendChild(button2);




                        var button3 = document.createElement("button");
                        button3.setAttribute("type","button");
                        button3.setAttribute("class","btn btn-danger");
                        button3.setAttribute("onclick","delFunc("+i+")" );

                        /*hover code*/
                        button3.setAttribute("data-toggle","tooltip");
                        button3.setAttribute("data-placement","top");
                        button3.setAttribute("title","Delete Domain");


                        var button3Inner = document.createElement("i");
                        button3Inner.setAttribute("class", "fa fa-times");
                        button3Inner.setAttribute("aria-hidden","true");
                        button3.appendChild(button3Inner);
                        cell.appendChild(button3);


                        row.appendChild(cell);







                    // add the row to the end of the table body
                    tblBody.appendChild(row);
                }

                // put the <tbody> in the <table>
                tbl.appendChild(tblBody);
                // appends <table> into <body>
                //body.appendChild(tbl);
                // sets the border attribute of tbl to 2;
                tbl.setAttribute("border", "2");


              /*  var dynamicTable = "<tr>\n" +
                    "<th>Domain Name</th>\n" +
                    "<th>Domain Qualification</th>\n" +
                    "<th>Domain Capacity</th>\n" +
                    "</tr>";
                for(var i=0 ; i < jd.length ; i++)
                {
                    var dObject = jd[i];
                    dynamicTable = "<tr>" +
                        "<td>" + dObject.d_name + "</td>" +
                        "<td>"+dObject.d_qualification +"</td>" +
                        "<td>"+ dObject.d_capacity+"</td>" +
                        "</tr>" ;
                }
                console.log(jd[0].d_name);

                document.getElementById("domTable").innerHTML = dynamicTable;*/
            });
}

function viewFunc(i) {

    var Url = location.origin+"/AcademicERP_war/webapi/student/getStudents";
    var data={
        d_code:101
    }

    data.d_code = global_jd[i].d_code;

    $.post(Url,data,function (data1, status) {

        document.getElementById("StudentTable").innerHTML = "";
        var tbl = document.getElementById("StudentTable");

        var tblBody = document.createElement("tbody");

        var headRow = document.createElement("tr");

        var hcell = document.createElement("th");
        var heading = document.createTextNode("Roll Number");
        hcell.appendChild(heading);
        headRow.appendChild(hcell);

        var hcell = document.createElement("th");
        var heading = document.createTextNode("Student Name");
        hcell.appendChild(heading);
        headRow.appendChild(hcell);

        tblBody.appendChild(headRow);
        for (var i = 0; i < data1.length; i++) {
            // creates a table row
            var row = document.createElement("tr");

            var cell = document.createElement("td");
            var cellText = document.createTextNode(data1[i].roll_no);
            cell.appendChild(cellText);
            row.appendChild(cell);

            var cell = document.createElement("td");
            var cellText = document.createTextNode(data1[i].name);
            cell.appendChild(cellText);
            row.appendChild(cell);


            // add the row to the end of the table body
            tblBody.appendChild(row);
        }

        // put the <tbody> in the <table>
        tbl.appendChild(tblBody);



            console.log(data1);
        // alert(data1);

    });

   // console.log("view Function "+i);
}

function delFunc(i) {

    $('#wait').show();
    //var Url = 'http://localhost:8080/AcademicERP_war/webapi/domain/delDomain';
    var Url = location.origin+"/AcademicERP_war/webapi/domain/delDomain";
    var data={
        d_code:101
    }

    data.d_code = global_jd[i].d_code;

    $.post(Url,data,function (data1, status) {
        $('#wait').hide();
           // alert(data1);

    });

    location.reload();


    console.log(data);
}

function modifyFunc(i){

    var mod_code = document.getElementById("mod_code").value = global_jd[i].d_code;
    var mod_name = document.getElementById("mod_name").value = global_jd[i].d_name;
    var mod_capacity = document.getElementById("mod_capacity").value = global_jd[i].d_capacity;
    var mod_qual = document.getElementById("mod_qual").value = global_jd[i].d_qualification;


    oldD_code = global_jd[i].d_code;

    console.log("Modify Function "+i);
}

function modifyPost() {

    //$('#wait').show();
    var Url = location.origin+"/AcademicERP_war/webapi/domain/modDomain";
    //var Url = 'http://localhost:8080/AcademicERP_war/webapi/domain/modDomain';

    var data={
        d_code:"101",
        d_name:"",
        d_capacity:"",
        d_qualification:"",
        d_oldDcode:""
    }

    data.d_oldDcode = oldD_code;
    data.d_code = document.getElementById("mod_code").value;
    data.d_name = document.getElementById("mod_name").value;
    data.d_capacity = document.getElementById("mod_capacity").value;
    data.d_qualification = document.getElementById("mod_qual").value;

    $.post(Url,data,function (data1, status) {
        //$('#wait').hide();
        //alert(data1);

    });

    location.reload();


}

function AddDomain() {
    //var Url = 'http://localhost:8080/AcademicERP_war/webapi/domain/addDomain';
    var Url = location.origin+"/AcademicERP_war/webapi/domain/addDomain";

    var data={
        d_code:"101",
        d_name:"",
        d_capacity:"",
        d_qualification:""
    }

    data.d_code = document.getElementById("add_code").value;
    data.d_name = document.getElementById("add_name").value;
    data.d_capacity = document.getElementById("add_capacity").value;
    data.d_qualification = document.getElementById("add_qual").value;

    $.post(Url,data,function (data1, status) {
        $('#wait').hide();
       // alert(data1);

    });

    location.reload();
}