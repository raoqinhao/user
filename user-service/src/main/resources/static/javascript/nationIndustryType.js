var form = null;
layui.use(['form', 'table'], function () {
    form = layui.form;
    form.on('select(nationIndustryTypeName_1)', function (data) {
        loadSelectData(data.elem.value, 1);
    });
    form.on('select(nationIndustryTypeName_2)', function (data) {
        loadSelectData(data.elem.value, 2);
        form.render();
    });
    form.on('select(nationIndustryTypeName_3)', function (data) {
        loadSelectData(data.elem.value, 3);
        form.render();
    });
    form.on('select(nationIndustryTypeName_4)', function (data) {
        loadSelectData(data.elem.value, 4);
    });
});

function loadSelectData(value, id) {
    if (id == "1") {
        var nationIndustryTypeName_2 = document.getElementById("nationIndustryTypeName_2");
        nationIndustryTypeName_2.options.length = 0;
        var nationIndustryTypeName_3 = document.getElementById("nationIndustryTypeName_3");
        nationIndustryTypeName_3.options.length = 0;
        var nationIndustryTypeName_4 = document.getElementById("nationIndustryTypeName_4");
        nationIndustryTypeName_4.options.length = 0;
        nationIndustryTypeName_2.add(new Option("请选择二级", ""));
        nationIndustryTypeName_3.add(new Option("请选择三级", ""));
        nationIndustryTypeName_4.add(new Option("请选择四级", ""));
        for (var i in nationIndustryTypeJson) {
            if (value == nationIndustryTypeJson[i].baseTypeId) {
                nationIndustryTypeJson_2 = nationIndustryTypeJson[i].dbasetype1s;
                for (var j in nationIndustryTypeJson[i].dbasetype1s) {
                    nationIndustryTypeName_2.add(new Option(nationIndustryTypeJson[i].dbasetype1s[j].baseTypeName, nationIndustryTypeJson[i].dbasetype1s[j].baseTypeId));
                }
            }
        }
    } else if (id == "2") {
        var nationIndustryTypeName_3 = document.getElementById("nationIndustryTypeName_3");
        nationIndustryTypeName_3.options.length = 0;
        var nationIndustryTypeName_4 = document.getElementById("nationIndustryTypeName_4");
        nationIndustryTypeName_4.options.length = 0;
        nationIndustryTypeName_3.add(new Option("请选择三级", ""));
        nationIndustryTypeName_4.add(new Option("请选择四级", ""));
        for (var i in nationIndustryTypeJson_2) {
            if (value == nationIndustryTypeJson_2[i].baseTypeId) {
                nationIndustryTypeJson_3 = nationIndustryTypeJson_2[i].dbasetype1s;
                for (var j in nationIndustryTypeJson_2[i].dbasetype1s) {
                    nationIndustryTypeName_3.add(new Option(nationIndustryTypeJson_2[i].dbasetype1s[j].baseTypeName, nationIndustryTypeJson_2[i].dbasetype1s[j].baseTypeId));
                }
            }
        }
    } else if (id == "3") {
        var nationIndustryTypeName_4 = document.getElementById("nationIndustryTypeName_4");
        nationIndustryTypeName_4.options.length = 0;
        nationIndustryTypeName_4.add(new Option("请选择四级", ""));
        for (var i in nationIndustryTypeJson_3) {
            if (value == nationIndustryTypeJson_3[i].baseTypeId) {
                for (var j in nationIndustryTypeJson_3[i].dbasetype1s) {
                    nationIndustryTypeName_4.add(new Option(nationIndustryTypeJson_3[i].dbasetype1s[j].baseTypeName, nationIndustryTypeJson_3[i].dbasetype1s[j].baseTypeId));
                }
            }
        }
    } else if (id == "4") {
        var nationIndustryTypeName_1 = $("#nationIndustryTypeName_1").find("option:selected").text();
        var nationIndustryTypeName_2 = $("#nationIndustryTypeName_2").find("option:selected").text();
        var nationIndustryTypeName_3 = $("#nationIndustryTypeName_3").find("option:selected").text();
        var nationIndustryTypeName_4 = $("#nationIndustryTypeName_4").find("option:selected").text();
        $("#nationIndustryTypeText").val(nationIndustryTypeName_1 + "-" + nationIndustryTypeName_2 + "-" + nationIndustryTypeName_3 + "-" + nationIndustryTypeName_4);
    }
    form.render();
}

//行业类型查询四级节点
//父节点
var parentNode = null;
//子节点
var node = null;
//节点层数
var nodeLevel = 1;

function getNode(json, nodeId, level) {
    for (var i = 0; i < json.length; i++) {
        if (node) {
            break;
        }
        var obj = json[i];
        //没有就下一个
        if (!obj || !obj.baseTypeId) {
            continue;
        }
        //2.有节点就开始找，一直递归下去
        if (obj.baseTypeId == nodeId) {
            //找到了与nodeId匹配的节点，结束递归
            node = obj;
            break;
        } else {
            if (level == nodeLevel) {
                continue;
            }
            //3.如果有子节点就开始找
            if (obj.dbasetype1s) {
                nodeLevel++;
                //4.递归前，记录当前节点，作为parent 父亲
                parentNode = obj;
                //递归往下找
                getNode(obj.dbasetype1s, nodeId, level);
            } else {
                //跳出当前递归，返回上层递归
                continue;
            }
        }
    }
    //5.如果木有找到父节点，置为null，因为没有父亲
    if (!node) {
        parentNode = null;
        nodeLevel--;
    }
    //6.返回结果obj
    return {
        parentNode: parentNode,
        node: node
    };
}

//初始化查询node节点
function initNode() {
    firstNode = null;
    secondNode = null;
    thirdNode = null;
    node = null;
    parentNode = null;
    nodeLevel = 1;
}

//一级节点
var firstNode = null;
//二级
var secondNode = null;
//三级
var thirdNode = null;

function getAllNode(json, nodeId) {
    for (var i = 0; i < json.length; i++) {
        if (node) {
            break;
        }
        var obj = json[i];
        //没有就下一个
        if (!obj || !obj.baseTypeId) {
            continue;
        }
        //2.有节点就开始找，一直递归下去
        if (obj.baseTypeId == nodeId) {
            //找到了与nodeId匹配的节点，结束递归
            node = obj;
            break;
        } else {
            //3.如果有子节点就开始找
            if (obj.dbasetype1s) {
                if (nodeLevel == 1) {
                    firstNode = obj;
                }
                if (nodeLevel == 2) {
                    secondNode = obj;
                }
                if (nodeLevel == 3) {
                    thirdNode = obj;
                }
                nodeLevel++;
                //4.递归前，记录当前节点，作为parent 父亲
                parentNode = obj;
                //递归往下找
                getAllNode(obj.dbasetype1s, nodeId);
            } else {
                //跳出当前递归，返回上层递归
                continue;
            }
        }
    }
    //5.如果木有找到父节点，置为null，因为没有父亲
    if (!node) {
        parentNode = null;
        nodeLevel--;
        if (nodeLevel == 1) {
            firstNode = null;
        }
        if (nodeLevel == 2) {
            secondNode = null;
        }
        if (nodeLevel == 3) {
            thirdNode = null;
        }
    }
    //6.返回结果obj
    return {
        firstNode: firstNode,
        secondNode: secondNode,
        thirdNode: thirdNode,
        parentNode: parentNode,
        node: node
    };
}
