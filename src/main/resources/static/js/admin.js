$("#schools").ready(function () {
    $.get("/school/schools",function (data, status) {
        const contents = document.getElementById("contents");
        const schools = JSON.parse(JSON.stringify(data));
        if (typeof (schools[0] !== 'undefined')) {
            for (let i = 0; i < schools.length; i++) {
                const nDiv = document.createElement("div");
                const nCard = document.createElement("div");
                const nCardBody = document.createElement("div");
                nDiv.className="col-3";
                nCard.className="card";
                nCardBody.className="card-body d-grid";
                const btn = document.createElement("a");
                btn.innerHTML=schools[i].name;
                btn.href="/school/" + schools[i].id;
                btn.className="btn btn-block";
                nCardBody.appendChild(btn);
                nCard.appendChild(nCardBody);
                nDiv.appendChild(nCard);
                contents.appendChild(nDiv);
            }
        }
        const add = document.createElement("button");
        add.className="btn btn-pri"
    })
})

function getSchool(id) {

}