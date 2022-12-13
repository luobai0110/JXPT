$("#t_class").ready(function () {
    $.get("/t_class/t_classes",function (data,status) {
        const tClass2 = JSON.parse(JSON.stringify(data));
        let nTds = createTd(4)
        nTds[0].innerHTML="编号";
        nTds[1].innerHTML="专业";
        nTds[2].innerHTML="班级";
        nTds[3].innerHTML="操作";
        addBody("theadParent", nTds);
        for (let i = 0 ; i < tClass2.length; i++) {
            const nTr = document.createElement("tr");
            let nTds = createTd(4);
            nTds[0].innerHTML=tClass2[i].tclassId;
            nTds[1].innerHTML=tClass2[i].majorName;
            nTds[2].innerHTML=tClass2[i].tclassName;
            const nA=document.createElement("a");
            nA.href="/t_class/" + tClass2[i].tclassId;
            nTds[3].appendChild(nA);
            addBody("tbodyParent",nTds);
        }
    })
})
function createTd(length) {
    let nTds = new Array(length);
    for (let i = 0; i < length; i++) {
        nTds[i]=document.createElement("td");
    }
    return nTds;
}

function addBody(parent, nTds) {
    const nTr = document.createElement("tr");
    for (let i = 0; i < 4;i++) {
        nTr.appendChild(nTds[i]);
    }
    document.getElementById(parent).appendChild(nTr);
}