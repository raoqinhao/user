//导航事件
function loadClickFunction(){
    var searchElement = document.querySelectorAll('#searchElement li');
    for (var i = 0; i < searchElement.length; i++) {
        searchElement[i].onclick = (function (i) {
            return function () {
                chooseElement(searchElement, i);
                //currenValue(tabItem, i)
            }
        })(i);
    }
}

function chooseElement(obj,index){
    var searchElement = document.querySelectorAll('#searchElement li');
    for (var i = 0; i < searchElement.length; i++) {
        searchElement[i].classList.remove('whole-district');
        searchElement[i].classList.remove('layui-this');
    }
    searchElement[index].classList.add('whole-district');
    searchElement[index].classList.add('layui-this');
    var id = searchElement[index].id;
    var text = searchElement[index].textContent;
    var isEndNode = searchElement[index].getAttribute("isEndNode");
    var dataType = searchElement[index].getAttribute("dataType");
    loadSearchSecondElement(id,text,isEndNode,dataType);
    var secondElementDiv = $("#searchElement_2");
    if(secondElementDiv[0].childNodes.length > 0){
        secondElementDiv[0].style.display = "";
    }
    $("[name='extraElements']").remove();
}

function loadSearchElement(elementType){
    var jsonStr = {
        elementType : elementType
    };
    var url = contextPath + "enterprise/enterpriseEsSearch/getQueryElementsTableList";
    var result = loadingAjaxJsonData(url, jsonStr);
    if(result.code == "0") {
        var data = result.data;
        var html = "";
        for(var i = 0;i < data.length;i ++){
            var id = data[i].elementId;
            var text = data[i].elementName;
            var isEndNode = data[i].isEndNode;
            var dataType = data[i].dataType;
            var chartType = data[i].chartType;
            if(chartType == "3" && parent.isSearchDepartment){
                html += "<li class=\"elementLi\" id=\"element_9999\" isEndNode=\"0\" dataType=\"9999\">对口监管部门</li>";
            }else{
                html += "<li class=\"elementLi\" id=\"element_"+id+"\" isEndNode=\""+isEndNode+"\" dataType=\""+dataType+"\">"+text+"</li>";
            }
        }
        $("#searchElement").html(html);
        loadClickFunction();
    }
}

function loadSearchSecondElement(id,text,isEndNode,dataType){
    var html = "";
    if(isEndNode == "1"){
        if(dataType == "4"){ //需输入数据查询
            var elementId = id.split("_")[1];
            var jsonStr = {
                elementId : elementId
            };
            var url = contextPath + "enterprise/enterpriseEsSearch/getTableElementFieldById";
            var result = loadingAjaxJsonData(url, jsonStr);
            if(result.code == "0") {
                var data = result.data;
                var tabName = data[0].tabName;
                var queKey = data[0].queKey;
                var queVal = data[0].queVal;
                var queType = data[0].queType;
                var queMode = data[0].queMode;
                var isEndNode = data[0].isEndNode;
                html = "<li>" +
                    "<label class=\"layui-form-label\">"+text+"：</label>" +
                    "<div class=\"layui-input-inline\">" +
                    "<input type=\"text\" id=\"element_"+elementId+"_"+queKey+"\" onblur=\"addElements(this.id,'"+text+":'+this.value,this.value,'"+tabName+"','"+queKey+"','"+queType+"','"+isEndNode+"');\" class=\"layui-input elementsInput\" placeholder=\"请输入"+text+"\">" +
                    "</div>" +
                    "</li>";
                $("#searchElement_2").html(html);
            }
        }else if(dataType == "7"){
            var elementId = id.split("_")[1];
            var jsonStr = {
                elementId : elementId
            };
            var url = contextPath + "enterprise/enterpriseEsSearch/getTableElementFieldById";
            var result = loadingAjaxJsonData(url, jsonStr);
            if(result.code == "0") {
                var data = result.data;
                var tabName = data[0].tabName;
                var queKey = data[0].queKey;
                var queVal = data[0].queVal;
                var queType = data[0].queType;
                var queMode = data[0].queMode;
                var isEndNode = data[0].isEndNode;
                html = "<li>" +
                    "<label class=\"layui-form-label\">"+text+"：</label>" +
                    "<div class=\"layui-input-inline\">" +
                    "<input type=\"text\" id=\"element_"+elementId+"_"+queKey+"\" readonly queText=\""+text+"\" tabName=\""+tabName+"\" queKey=\""+queKey+"\" queType=\""+queType+"\" class=\"layui-input elementsInput\" placeholder=\"请输入"+text+"\">" +
                    "</div>" +
                    "</li>";
                $("#searchElement_2").html(html);
                var option = {
                    elem: document.getElementById('element_'+queKey)
                    ,change: function(value, date, endDate){
                        addElements('element_'+queKey,text+":"+value,value,tabName,queKey,queType,isEndNode);
                    }
                    ,done: function(value, date, endDate){
                        addElements('element_'+queKey,text+":"+value,value,tabName,queKey,queType,isEndNode);
                    }};
                laydate.render(option);
            }
        }else if(dataType == "8"){
            var elementId = id.split("_")[1];
            var jsonStr = {
                elementId : elementId
            };
            var url = contextPath + "enterprise/enterpriseEsSearch/getTableElementFieldById";
            var result = loadingAjaxJsonData(url, jsonStr);
            if(result.code == "0") {
                var data = result.data;
                var tabName = data[0].tabName;
                var queKey = data[0].queKey;
                var queVal = data[0].queVal;
                var queType = data[0].queType;
                var queMode = data[0].queMode;
                html = "<li>" +
                    "<div class='layui-inline' style='margin: 0px;'>" +
                    "<label class=\"layui-form-label\">"+text+"：</label>" +
                    "<div class=\"layui-input-inline\">" +
                    "<input type=\"text\" id=\"element_"+elementId+"_"+queKey+"_1\" readonly queText=\""+text+"大于\" tabName=\""+tabName+"\" queKey=\""+queKey+"\" queType=\""+queType+"\" class=\"layui-input elementsInput\" placeholder=\"请输入"+text+"\">" +
                    "</div>" +
                    "<div class=\"layui-form-mid toEnd\">至</div>"+
                    "<div class=\"layui-input-inline\">" +
                    "<input type=\"text\" id=\"element_"+elementId+"_"+queKey+"_2\" readonly queText=\""+text+"小于\" tabName=\""+tabName+"\" queKey=\""+queKey+"\" queType=\""+queType+"\" class=\"layui-input elementsInput\" placeholder=\"请输入"+text+"\">" +
                    "</div>" +
                    "</div>" +
                    "</li>";
                $("#searchElement_2").html(html);
                loadDateElement("element_"+elementId+"_"+queKey+"_1","element_"+elementId+"_"+queKey+"_2");
            }
        }
    }else{
        if(dataType == "5"){ //通过路径读取数据
            var elementId = id.split("_")[1];
            var jsonStr = {
                elementId : elementId
            };
            var url = contextPath + "enterprise/enterpriseEsSearch/getTableChildElementById";
            var result = loadingAjaxJsonData(url, jsonStr);
            if(result.code == "0") {
                var data = result.data;
                var childElementId = data[0].elementId;
                var elementUrl = contextPath + data[0].dataUrl;
                var elementParams = null;
                if(data[0].dataParams != undefined && data[0].dataParams != ""){
                    elementParams = data[0].dataParams;
                }
                var resultParams = data[0].resultParams;
                var resultParamId = resultParams.split("||")[0];
                var resultParamName = resultParams.split("||")[1];
                var loadResult = loadingAjaxJsonData(elementUrl, elementParams);
                if(loadResult instanceof Array){
                    var resultArray = new Array();
                    var tableType = data[0].queElementArray[0].tab_name;
                    var tableField = data[0].queElementArray[0].tab_eles[0].que_key;
                    var queType = data[0].queElementArray[0].tab_eles[0].que_type;
                    var queMode = data[0].queElementArray[0].tab_eles[0].que_mode;
                    var isEndNode = data[0].isEndNode;
                    //是否为独立条件 不添加默认条件
                    var childDataType = data[0].dataType;
                    var isDependent = false;
                    if(childDataType == "10"){
                        isDependent = true;
                    }
                    for(var i = 0;i < loadResult.length;i ++){
                        var resultObj = {
                            "key":loadResult[i][resultParamName],
                            "value":loadResult[i][resultParamId],
                            "showText":loadResult[i][resultParamName],
                            "queKey":tableField,
                            "queType":queType,
                            "queMode":queMode,
                            "isDependent": isDependent
                        };
                        resultArray.push(resultObj);
                    }
                    var searchElement = {
                        tableType : tableType,
                        tableField : tableField,
                        //queType : queType,
                        isEndNode : isEndNode,
                        elementId : childElementId
                    };
                    html = createChooseHtml(resultArray,tableField,searchElement);
                    $("#searchElement_2").html(html);
                }else{
                    if(loadResult.code == "0"){
                        var loadResultData = loadResult.data;
                        var resultArray = new Array();
                        var tableType = data[0].queElementArray[0].tab_name;
                        var tableField = data[0].queElementArray[0].tab_eles[0].que_key;
                        var queType = data[0].queElementArray[0].tab_eles[0].que_type;
                        var queMode = data[0].queElementArray[0].tab_eles[0].que_mode;
                        var isEndNode = data[0].isEndNode;
                        //是否为独立条件 不添加默认条件
                        var childDataType = data[0].dataType;
                        var isDependent = false;
                        if(childDataType == "10"){
                            isDependent = true;
                        }
                        for(var i = 0;i < loadResultData.length;i ++){
                            var resultObj = {
                                "key":loadResultData[i][resultParamName],
                                "value":loadResultData[i][resultParamId],
                                "showText":loadResultData[i][resultParamName],
                                "queKey":tableField,
                                "queType" : queType,
                                "queMode":queMode,
                                "isDependent": isDependent
                            };
                            resultArray.push(resultObj);
                        }
                        var searchElement = {
                            tableType : tableType,
                            tableField : tableField,
                            isEndNode : isEndNode,
                            elementId : childElementId
                        };
                        html = createChooseHtml(resultArray,tableField,searchElement);
                        $("#searchElement_2").html(html);
                    }
                }
            }
        }else if(dataType == "6") { //数据库固定数据
            var elementId = id.split("_")[1];
            var jsonStr = {
                elementId: elementId
            };
            var url = contextPath + "enterprise/enterpriseEsSearch/getTableChildElementById";
            var result = loadingAjaxJsonData(url, jsonStr);
            if (result.code == "0") {
                var data = result.data;
                var resultArray = new Array();
                var childElementId = data[0].elementId;
                //var isEndNode = data[0].isEndNode;
                var tableType = data[0].queElementArray[0].tab_name;
                var tableField = data[0].queElementArray[0].tab_eles[0].que_key;
                var queType = data[0].queElementArray[0].tab_eles[0].que_type;
                var queMode = data[0].queElementArray[0].tab_eles[0].que_mode;
                for(var i = 0;i < data.length;i ++){
                    //是否为独立条件 不添加默认条件
                    var childDataType = data[i].dataType;
                    var isDependent = false;
                    if(childDataType == "10"){
                        isDependent = true;
                    }
                    var resultObj = {
                        "key":data[i].elementName,
                        "value":data[i].queElementArray[0].tab_eles[0].que_val,
                        "showText":data[i].elementName,
                        "queKey":data[i].queElementArray[0].tab_eles[0].que_key,
                        "queMode":data[i].queElementArray[0].tab_eles[0].que_mode,
                        "queType":data[i].queElementArray[0].tab_eles[0].que_type,
                        "isEndNode":data[i].isEndNode,
                        "isDependent": isDependent
                    };
                    resultArray.push(resultObj);
                }
                var searchElement = {
                    tableType : tableType,
                    tableField : tableField,
                    //queType : queType,
                    elementId : childElementId
                };
                html = createChooseHtml(resultArray,tableField,searchElement);
                $("#searchElement_2").html(html);
            }
        }else if(dataType == "9999"){
            //查询对口监管部门数据
            var departmentJson = {
                unifiedSocialCreditCode : parent.userOpptId
            };
            var departmentUrl = contextPath + "/organization/department/findIdepartment";
            var departmentResult = loadingAjaxJsonData(departmentUrl, departmentJson);
            if(departmentResult.code == "0") {
                var resultArray = [];
                var deparmentData = departmentResult.data;
                var queType = "6";
                var queKey = "SUPERVISIONDPTNAME.DEPARTMENTID";
                if(returnTable != "enterprise"){
                    queType = "3";
                    queKey = "REPORTDEPTID";
                }
                for(var i = 0;i < deparmentData.length;i ++){
                    var resultObj = {
                        "key":deparmentData[i].departmentName,
                        "value":deparmentData[i].departmentId,
                        "showText":deparmentData[i].departmentName,
                        "queKey":queKey,
                        "queType" : queType,
                        "isDependent": false
                    };
                    resultArray.push(resultObj);
                }
                if(returnTable == "enterprise"){
                    var searchElement = {
                        tableType : "enterprise",
                        tableField : "SUPERVISIONDPTNAME.DEPARTMENTID",
                        //queType : "6",
                        childElementId : 9999
                    };
                    html = createChooseHtml(resultArray,"SUPERVISIONDPTNAME.DEPARTMENTID",searchElement);
                    $("#searchElement_2").html(html);
                }else if(returnTable == "execution"){
                    var searchElement = {
                        tableType : "execution",
                        tableField : "REPORTDEPTID",
                        //queType : "3",
                        childElementId : 9999
                    };
                    html = createChooseHtml(resultArray,"REPORTDEPTID",searchElement);
                    $("#searchElement_2").html(html);
                }else if(returnTable == "accident"){
                    var searchElement = {
                        tableType : "accident",
                        tableField : "REPORTDEPTID",
                        //queType : "3",
                        childElementId : 9999
                    };
                    html = createChooseHtml(resultArray,"REPORTDEPTID",searchElement);
                    $("#searchElement_2").html(html);
                }

            }


        }
    }
}

//生成查询元素html
function createChooseHtml(data,searchField,searchElement){
    var html = "";
    var isEndNode = searchElement.isEndNode;
    var loadEndNode = false;
    if(isEndNode == null || isEndNode == undefined || isEndNode === ""){
        loadEndNode = true;
    }
    var returnJsonArray = findTotalByCondition(data,searchElement.tableField,searchElement.tableType);
    for(var i = 0;i < data.length;i ++){
        if(loadEndNode){
            isEndNode = data[i].isEndNode;
        }
        var total;
        for (var j = 0; j < returnJsonArray[0].item_content.length; j++) {
            if(data[i].key == returnJsonArray[0].item_content[j].key){
                total = returnJsonArray[0].item_content[j].doc_count;
            }
        }
        html += "<li id=\"element_"+searchElement.elementId+"_"+data[i].queKey+"_"+data[i].value+"_"+data[i].queMode+"\" " +
            "onclick=\"addElements(this.id,'"+data[i].showText+"','"+data[i].value+"','"+searchElement.tableType+"','"+data[i].queKey+"','"+data[i].queType+"','"+data[i].queMode+"','"+isEndNode+"','"+data[i].isDependent+"');\">" +
            ""+data[i].key+"("+total+")" +
            "</li>";
    }
    return html;
}

//添加查询元素
function addElements(id,name,value,tableType,tableField,queType,queMode,isEndNode,isDependent){
    if(isDependent == undefined || isDependent == null || isDependent === ""){
        isDependent = false;
    }
    var searchType = $("input[name='searchType']:checked").val();
    var searchElement = document.getElementById(id);
    var parentUlId = searchElement.parentNode.id;
    var parentId = parentUlId.split("_")[1];
    if(searchElement != null && searchElement != undefined && searchElement.tagName == "LI"){
        if(searchType == "1"){
            var childSearchElement = $("#searchElement_"+parentId)[0];
            var searchElementLi = childSearchElement.childNodes;
            for(var i = 0;i < searchElementLi.length;i ++){
                if(searchElementLi[i].classList.contains("secondLiSelected")){
                    searchElementLi[i].classList.remove("secondLiSelected");
                }
            }
        }
        if(searchElement.classList.contains("secondLiSelected")){
            searchElement.classList.remove("secondLiSelected");
        }else{
            searchElement.classList.add("secondLiSelected");
        }
    }
    var elementsValues = document.getElementsByName("elementsValue");
    var inputQueKeyId = id.split("element_")[1];
    var isAdd = false;
    var isExistOther = false;
    for(var i = 0;i< elementsValues.length;i ++) {
        var elementId = elementsValues[i].id;
        var elementQueType = elementsValues[i].getAttribute("queType");
        if(elementId == inputQueKeyId && queType == elementQueType){
            isAdd = true;
        }
        if(queType == "4"){
            elementId = elementId.substr(0,elementId.length - 2);
            if(elementId != inputQueKeyId.substr(0,inputQueKeyId.length - 2)){
                isExistOther = true;
            }
        }
    }
    if(value != ""){
        if(queType == "4" && searchType == "1"){
            if(isExistOther){
                $("#elements").html("");
            }
        }else{
            if(searchType == "1" && !isAdd){
                $("#elements").html("");
            }else if(isAdd && searchElement.tagName == "LI"){
                document.getElementById("elementsDiv_"+inputQueKeyId+"_"+queType).remove();
                searchElement.classList.remove("secondLiSelected");
            }
        }
        if(!isAdd){
            var html = "<div class=\"elementsDiv\" id=\"elementsDiv_"+inputQueKeyId+"_"+queType+"\">" +
                "<span>"+name+"</span>&nbsp;<i class=\"layui-icon layui-icon-close\" onclick=\"deleteElement(this,'"+id+"');\"></i>" +
                "<input type=\"hidden\" id=\""+inputQueKeyId+"\" name=\"elementsValue\" value=\""+value+"\" " +
                " tableType=\""+tableType+"\" tableField=\""+tableField+"\" queType=\""+queType+"\" queMode=\""+queMode+"\" isDependent=\""+isDependent+"\">" +
                "</div>";
            $("#elements").append(html);
        }else{
            var elementsDiv = document.getElementById("elementsDiv_"+inputQueKeyId+"_"+queType);
            var html = "<span>"+name+"</span>&nbsp;<i class=\"layui-icon layui-icon-close\" onclick=\"deleteElement(this,'"+id+"');\"></i>" +
                "<input type=\"hidden\" id=\""+inputQueKeyId+"\" name=\"elementsValue\" value=\""+value+"\" " +
                " tableType=\""+tableType+"\" tableField=\""+tableField+"\" queType=\""+queType+"\" queMode=\""+queMode+"\" isDependent=\""+isDependent+"\">";
            if(elementsDiv != null && elementsDiv != undefined){
                elementsDiv.innerHTML = html;
            }
        }
    }else{
        document.getElementById("elementsDiv_"+inputQueKeyId+"_"+queType).remove();
    }
    //有下级元素
    if(isEndNode == "0" && !isAdd){
        loadNextLevelElements(parseInt(parentId)+1,value);
    }else{
        //$("#searchElement_"+parseInt(parentId)+1).css("display","none");
    }

}

//删除查询元素
function deleteElement(obj,id){
    var searchElement = document.getElementById(id);
    if(searchElement != null && searchElement != undefined && searchElement.tagName == "LI"){
        if(searchElement.classList.contains("secondLiSelected")){
            searchElement.classList.remove("secondLiSelected");
        }
    }else if(searchElement != null && searchElement != undefined && searchElement.tagName == "INPUT"){
        searchElement.value = "";
        var dateType = id.split("_")[id.split("_").length-1];
        if(id.indexOf("DATE") > -1 && (dateType.indexOf("1") > -1 || dateType.indexOf("2") > -1)){
            if(dateType == "1"){
                layEndElement.config.min.year = '1900';
                layEndElement.config.min.month = '1';
                layEndElement.config.min.date = '1';
            }else if(dateType == "2"){
                layStartElement.config.max.year = '2100';
                layStartElement.config.max.month = '11';
                layStartElement.config.max.date = '31';
            }
        }
    }
    $(obj).parent().remove();
}

//清楚查询元素
function clearElements(){
    var searchElement = document.querySelectorAll('#searchElement li');
    for (var i = 0; i < searchElement.length; i++) {
        searchElement[i].classList.remove('whole-district');
        searchElement[i].classList.remove('layui-this');
    }
    $("#searchElement_2").html("");
    $("#searchElement_2").css("display","none");
    $("#elements").html("");
    searchData();
}

function findTotalByCondition(institutionsJsonArray,quekey,queTable){
    var tableResult = null;
    var groupElements = [];
    var extraEles = null;
    if(extraDefaultListElement != undefined && extraDefaultListElement != ""){
        extraEles = JSON.parse(JSON.stringify(extraDefaultListElement));
        // for(var i = 0;i < extraDefaultListElement.length;i ++){
        //     enterpriseElements.push(extraDefaultListElement[i]);
        // }
    }
    if(extraEles == null){
        extraEles = [{
            tab_name : returnTable,
            que_eles : []
        }]
    }
    // var queType = "3";
    // if(quekey.split(".").length > 1){
    //     queType = "6";
    // }
    var dependentArray = [];
    for(var i = 0;i < institutionsJsonArray.length;i ++){
        //独立条件
        if(institutionsJsonArray[i].isDependent == true){
            var groupElement = {
                item_name : institutionsJsonArray[i].key,
                item_eles : [{
                    tab_name : queTable,
                    tab_eles : [
                        {
                            que_key : institutionsJsonArray[i].queKey,
                            que_val : institutionsJsonArray[i].value,
                            que_type : institutionsJsonArray[i].queType,
                            que_mode : institutionsJsonArray[i].queMode
                        }
                    ]
                }]
            };
            dependentArray.push(groupElement);
            continue;
        }
        var groupElement = {
            item_name : institutionsJsonArray[i].key,
            item_eles : [{
                tab_name : queTable,
                tab_eles : [
                    {
                        que_key : institutionsJsonArray[i].queKey,
                        que_val : institutionsJsonArray[i].value,
                        que_type : institutionsJsonArray[i].queType,
                        que_mode : institutionsJsonArray[i].queMode
                    }
                ]
            }]
        };
        groupElements.push(groupElement);
    }
    var tab_parent = "";
    if(parentTable != undefined && parentTable != null && parentTable != ""){
        tab_parent = parentTable;
    }else{
        tab_parent = returnTable;
    }
    var jsonStr = {
        indexType : returnTable,
        //分组参数
        elements : []
        //聚和参数
        ,resultElementJson : {
            tab_relation : "",
            tab_parent : tab_parent,
            agg_items : [{
                item_text : "数量",
                tab_return : returnTable,
                item_eles : extraEles
                // item_eles : [{
                //     tab_name : returnTable,
                //     que_eles : enterpriseElements
                // }]
            }]
        }
    };

    jsonStr.elements = groupElements;
    var url = contextPath + aggUrl;
    var result = loadingAjaxJsonData(url, jsonStr);
    if(result.code === "0") {
        tableResult = result.data;
    }

    //独立查询
    //去除默认参数中的重复参数 取独立参数
    var dependentExtraEles = [];
    for(var i = 0;i < extraEles.length;i ++){
        var extraTabName = extraEles[i].tab_name;
        for(var j = 0;j < dependentArray.length;j ++){
            for(var k = 0;k < dependentArray[j].item_eles.length;k ++){
                var dependentTabName = dependentArray[j].item_eles[k].tab_name;
                if(dependentTabName == extraTabName){
                    for(var m = 0;m < extraEles[i].que_eles.length;m ++){
                        var extraKey = extraEles[i].que_eles[m].que_key;
                        for(var n = 0;n < dependentArray[j].item_eles[k].tab_eles.length;n ++){
                            var dependentKey = dependentArray[j].item_eles[k].tab_eles[k].que_key;
                            if(extraKey == dependentKey){
                                extraEles[i].que_eles.splice(m,1);
                            }else{
                                continue;
                            }
                        }
                    }
                }else{
                    continue;
                }
            }
        }
    }
    dependentExtraEles = extraEles;
    var dependentJsonStr = {
        indexType : returnTable,
        //分组参数
        elements : dependentArray
        //聚和参数
        ,resultElementJson : {
            tab_relation : "",
            tab_parent : tab_parent,
            agg_items : [{
                item_text : "数量",
                tab_return : returnTable,
                item_eles : dependentExtraEles
            }]
        }
    };
    var dependentUrl = contextPath + aggUrl;
    var dependentUrlResult = loadingAjaxJsonData(dependentUrl, dependentJsonStr);
    if(dependentUrlResult.code === "0") {
        var itemContent = dependentUrlResult.data[0].item_content;
        tableResult[0].item_content = tableResult[0].item_content.concat(itemContent);
    }
    return tableResult;
}

//获取 组合所有查询条件
function getElementsArray(){
    var elementsValues = document.getElementsByName("elementsValue");
    //所有条件集合
    var elementsArray = [];
    var isDependent = false;
    //添加条件
    for(var i = 0;i< elementsValues.length;i ++){
        var id = elementsValues[i].id;
        var value = elementsValues[i].value;
        //查询字段表类型
        var tableType = elementsValues[i].attributes["tableType"].nodeValue;
        //查询字段
        var tableField = elementsValues[i].attributes["tableField"].nodeValue;
        //查询模式
        var queType = elementsValues[i].attributes["queType"].nodeValue;
        //查询条件
        var queMode = elementsValues[i].attributes["queMode"].nodeValue;
        //是否为独立查询
        var nodeDependent = elementsValues[i].attributes["isDependent"].nodeValue;
        if(nodeDependent == "true"){
            isDependent = true;
        }

        if(queMode == undefined || queMode == ""){
            queMode = "1";
        }
        //range查询模式
        var queType_2 = null;
        if(queType == "4"){
            queType_2 = id.split("_")[1];
            if(value.indexOf(",") < 0){
                if(queType_2 == "1"){
                    queType = "4.1";
                }else if(queType_2 == "2"){
                    queType = "4.3";
                }
            }
        }

        var isExistTable = [];
        for(var j in elementsArray){
            if(elementsArray[j].tab_name == returnTable){
                isExistTable.push(elementsArray[j]);
            }
        }
        if(isExistTable != null && isExistTable.length > 0){
            var isExistKey = [];
            for(var j in isExistTable[0].que_eles){
                if(isExistTable[0].que_eles[j].que_key == tableField && queType == isExistTable[0].que_eles[j].que_type){
                    isExistKey.push(isExistTable[0].que_eles[j]);
                }
            }
            if(isExistKey != null && isExistKey.length > 0){
                if(queType == "6.3"){
                    var searchElement = {
                        que_key : tableField,
                        que_val : value,
                        que_type : queType,
                        que_mode : queMode
                    };
                    isExistTable[0].que_eles.push(searchElement);
                }else{
                    isExistKey[0].que_val += "," +value;
                }
            }else{
                if(queType.indexOf("||") > -1){
                    var queTypeArray = queType.split("||");
                    for(var j in queTypeArray){
                        var searchElement = {
                            que_key : tableField,
                            que_val : value,
                            que_type : queTypeArray[j],
                            que_mode : "3"
                        };
                        isExistTable[0].que_eles.push(searchElement);
                    }
                }else{
                    var searchElement = {
                        que_key : tableField,
                        que_val : value,
                        que_type : queType,
                        que_mode : queMode
                    };
                    isExistTable[0].que_eles.push(searchElement);
                }
            }
        }else{
            var element = {
                tab_name : tableType,
                que_eles : []
            };
            if(queType.indexOf("||") > -1){
                var queTypeArray = queType.split("||");
                for(var j in queTypeArray){
                    var searchElement = {
                        que_key : tableField,
                        que_val : value,
                        que_type : queTypeArray[j],
                        que_mode : "3"
                    };
                    element.que_eles.push(searchElement);
                }
            }else{
                var searchElement = {
                    que_key : tableField,
                    que_val : value,
                    que_type : queType,
                    que_mode : queMode
                };
                element.que_eles.push(searchElement);
            }
            elementsArray.push(element);
        }
    }
    if(extraDefaultListElement != undefined && extraDefaultListElement != null && extraDefaultListElement != "" && isDependent != true){
        if(elementsArray.length > 0){
            for(var j = 0;j < extraDefaultListElement.length;j ++){
                var extraTabName = extraDefaultListElement[j].tab_name;
                var extraEles = JSON.parse(JSON.stringify(extraDefaultListElement[j].que_eles));
                var isExist = false;
                for(var i in elementsArray){
                    if(elementsArray[i].tab_name == extraTabName){
                        isExist = true;
                        elementsArray[i].que_eles = elementsArray[i].que_eles.concat(extraEles);
                        break;
                        // elementsArray[i].que_eles.push(extraDefaultListElement[j]);
                    }
                }
                if(!isExist){
                    var extraElements = {
                        tab_name : extraTabName,
                        que_eles : extraEles
                    };
                    elementsArray.push(extraElements);
                }
            }
        }else{
            elementsArray = JSON.parse(JSON.stringify(extraDefaultListElement));
            // var otherElement = {
            //     tab_name : returnTable,
            //     que_eles : extraDefaultListElement
            // };
            // elementsArray.push(otherElement);
        }
    }else if(isDependent == true && extraDefaultListElement != undefined && extraDefaultListElement != null && extraDefaultListElement != ""){
        for(var j = 0;j < extraDefaultListElement.length;j ++){
            var extraTabName = extraDefaultListElement[j].tab_name;
            var extraEles = JSON.parse(JSON.stringify(extraDefaultListElement[j].que_eles));
            var isExist = false;
            for(var i in elementsArray){
                if(elementsArray[i].tab_name == extraTabName){
                    isExist = true;
                    for(var k in elementsArray[i].que_eles){
                        var elementsArrayKey = elementsArray[i].que_eles[k].que_key;
                        for(var m in extraEles){
                            var extraKey = extraEles[m].que_key;
                            if(extraKey == elementsArrayKey){
                                extraEles.splice(m,1);
                                continue;
                            }
                        }
                    }

                    elementsArray[i].que_eles = elementsArray[i].que_eles.concat(extraEles);
                    break;
                    // elementsArray[i].que_eles.push(extraDefaultListElement[j]);
                }
            }
            if(!isExist){
                var extraElements = {
                    tab_name : extraTabName,
                    que_eles : extraEles
                };
                elementsArray.push(extraElements);
            }
        }
    }
    return elementsArray;
}

var layStartElement = null;
var layEndElement = null;
function loadDateElement(startId,stopId){
    var laydateMaxDate = "2099-12-31 23:59:59";
    var laydateMinDate = "1900-1-1 00:00:00";
    var startIdDate = $("#"+startId).val();
    var stopIdDate = $("#"+stopId).val();
    if(startIdDate != null && startIdDate != undefined && startIdDate != ""){
        laydateMinDate = startIdDate;
    }
    if(stopIdDate != null && stopIdDate != undefined && stopIdDate != ""){
        laydateMaxDate = stopIdDate;
    }
    var startDate = laydate.render({
        elem: '#'+startId,
        max: laydateMaxDate,
        done:function(value,date){
            if( value !== '' ){
                var minDateYear = startDate.config.max.year;
                var minDateMonth = startDate.config.max.month+1;
                var minDateDay = startDate.config.max.date;
                var minDate = minDateYear + "-" + minDateMonth + "-" + minDateDay;
                var time = new Date(Date.parse(value));
                var time2 = new Date(Date.parse(minDate));
                if(time > time2) {
                    $("#"+startId).val("");
                    top.layer.msg('选择现在时间大于结束时间！', {icon: 5});
                    return false;
                }else{
                    endDate.config.min.year = date.year;
                    endDate.config.min.month = date.month - 1;
                    endDate.config.min.date = date.date;
                }
            }else{
                endDate.config.min.year = '1900';
                endDate.config.min.month = '1';
                endDate.config.min.date = '1';
            }
            $("#"+startId).change();
            var queKey = $("#"+startId).attr("queKey");
            var tabName = $("#"+startId).attr("tabName");
            var text = $("#"+startId).attr("queText");
            addElements(startId,text+":"+value,value,tabName,queKey,"4","","1");
        },
        change: function(value, date, endDate){
            var queKey = $("#"+startId).attr("queKey");
            var tabName = $("#"+startId).attr("tabName");
            var text = $("#"+startId).attr("queText");
            addElements(startId,text+":"+value,value,tabName,queKey,"4","","1");
        }
    });

    var endDate = laydate.render({
        elem: '#'+stopId,
        min: laydateMinDate,
        done:function(value,date){
            if( value !== '' ){
                var maxDateYear = endDate.config.min.year;
                var maxDateMonth = endDate.config.min.month+1;
                var maxDateDay = endDate.config.min.date;
                var maxDate = maxDateYear + "-" + maxDateMonth + "-" + maxDateDay;
                var time = new Date(Date.parse(value));
                var time2 = new Date(Date.parse(maxDate));
                if(time < time2) {
                    $("#"+stopId).val("");
                    top.layer.msg('选择现在时间小于开始时间！', {icon: 5});
                    return false;
                }else{
                    startDate.config.max.year = date.year;
                    startDate.config.max.month = date.month - 1;
                    startDate.config.max.date = date.date;
                }
            }else{
                startDate.config.max.year = '2099';
                startDate.config.max.month = '11';
                startDate.config.max.date = '31';
            }
            $("#"+stopId).change();
            var queKey = $("#"+stopId).attr("queKey");
            var tabName = $("#"+stopId).attr("tabName");
            var text = $("#"+stopId).attr("queText");
            addElements(stopId,text+":"+value,value,tabName,queKey,"4","","1");
        },
        change: function(value, date, endDate){
            var queKey = $("#"+stopId).attr("queKey");
            var tabName = $("#"+stopId).attr("tabName");
            var text = $("#"+stopId).attr("queText");
            addElements(stopId,text+":"+value,value,tabName,queKey,"4","","1");
        }
    });
    layStartElement = startDate;
    layEndElement = endDate;
}

function loadNextLevelElements(elementsUlId,value){
    var oldExtraElementsLength = $("[name='extraElements']").length + elementsUlId;
    if(oldExtraElementsLength > 0){
        for(var i = elementsUlId;i < oldExtraElementsLength;i ++){
            $("#searchElement_"+i).remove();
        }
    }
    var elementsUl = " <ul class=\"layui-tab-title second-tab-title\" id=\"searchElement_"+elementsUlId+"\" name=\"extraElements\" style=\"background-color: #fff;width:98%;border: 1px solid #ddd;display:none;padding:5px;border-radius: 3px;margin-left: 5px\">\n" +
        "</ul>"
    $("#elementsDiv").append(elementsUl);
    $("#searchElement_"+elementsUlId).css("display","");
    var selectedLi = $("#searchElement_"+(elementsUlId-1)+" li.secondLiSelected")[0];
    var elementId = selectedLi.id.split("_")[1];
    var jsonStr = {
        elementId : elementId
    };
    var url = contextPath + "enterprise/enterpriseEsSearch/getTableChildElementById";
    var result = loadingAjaxJsonData(url, jsonStr);
    if(result.code == "0") {
        var html = "";
        var data = result.data;
        var childElementId = data[0].elementId;
        var dataType = data[0].dataType;
        if(dataType == "5"){
            var elementUrl = contextPath + data[0].dataUrl;
            var elementParams = null;
            if (data[0].dataParams != undefined && data[0].dataParams != "") {
                elementParams = data[0].dataParams;
            }
            var elementParamsJSON = JSON.parse(elementParams);
            for(var key in elementParamsJSON){
                if(elementParamsJSON[key] == ""){
                    elementParamsJSON[key] = value;
                }
            }
            var resultParams = data[0].resultParams;
            var resultParamId = resultParams.split("||")[0];
            var resultParamName = resultParams.split("||")[1];
            var loadResult = loadingAjaxJsonData(elementUrl, elementParamsJSON);
            if (loadResult instanceof Array) {
                var resultArray = new Array();
                var tableType = data[0].queElementArray[0].tab_name;
                var tableField = data[0].queElementArray[0].tab_eles[0].que_key;
                var queType = data[0].queElementArray[0].tab_eles[0].que_type;
                var queMode = data[0].queElementArray[0].tab_eles[0].que_mode;
                var isEndNode = data[0].isEndNode;
                for (var i = 0; i < loadResult.length; i++) {
                    var isDependent = false;
                    if(data[0].dataType == "10"){
                        isDependent = true;
                    }
                    var resultObj = {
                        "key": loadResult[i][resultParamName],
                        "value": loadResult[i][resultParamId],
                        "showText": loadResult[i][resultParamName],
                        "queMode": queMode,
                        "queKey":data[0].queElementArray[0].tab_eles[0].que_key,
                        "queType":data[0].queElementArray[0].tab_eles[0].que_type,
                        "isEndNode":data[0].isEndNode,
                        "isDependent": isDependent
                    };
                    resultArray.push(resultObj);
                }
                var searchElement = {
                    tableType: tableType,
                    tableField: tableField,
                    //queType: queType,
                    isEndNode: isEndNode,
                    elementId : childElementId
                };
                html = createChooseHtml(resultArray, tableField, searchElement);
                $("#searchElement_"+elementsUlId).html(html);
            } else {
                if (loadResult.code == "0") {
                    var loadResultData = loadResult.data;
                    var resultArray = new Array();
                    var tableType = data[0].queElementArray[0].tab_name;
                    var tableField = data[0].queElementArray[0].tab_eles[0].que_key;
                    var queType = data[0].queElementArray[0].tab_eles[0].que_type;
                    var queMode = data[0].queElementArray[0].tab_eles[0].que_mode;
                    var isEndNode = data[0].isEndNode;
                    for (var i = 0; i < loadResultData.length; i++) {
                        var isDependent = false;
                        if(data[0].dataType == "10"){
                            isDependent = true;
                        }
                        var resultObj = {
                            "key": loadResultData[i][resultParamName],
                            "value": loadResultData[i][resultParamId],
                            "showText": loadResultData[i][resultParamName],
                            "queMode": queMode,
                            "queKey":data[0].queElementArray[0].tab_eles[0].que_key,
                            "queType":data[0].queElementArray[0].tab_eles[0].que_type,
                            "isEndNode":data[0].isEndNode,
                            "isDependent": isDependent
                        };
                        resultArray.push(resultObj);
                    }
                    var searchElement = {
                        tableType: tableType,
                        tableField: tableField,
                        //queType: queType,
                        isEndNode: isEndNode,
                        elementId : childElementId
                    };
                    html = createChooseHtml(resultArray, tableField, searchElement);
                    $("#searchElement_"+elementsUlId).html(html);
                }
            }
        }else if(dataType == "6"){
            var resultArray = new Array();
            var childElementId = data[0].elementId;
            //var isEndNode = data[0].isEndNode;
            var tableType = data[0].queElementArray[0].tab_name;
            var tableField = data[0].queElementArray[0].tab_eles[0].que_key;
            var queType = data[0].queElementArray[0].tab_eles[0].que_type;
            var queMode = data[0].queElementArray[0].tab_eles[0].que_mode;
            for(var i = 0;i < data.length;i ++){
                //是否为独立条件 不添加默认条件
                var childDataType = data[i].dataType;
                var isDependent = false;
                if(childDataType == "10"){
                    isDependent = true;
                }
                var resultObj = {
                    "key":data[i].elementName,
                    "value":data[i].queElementArray[0].tab_eles[0].que_val,
                    "showText":data[i].elementName,
                    "queKey":data[i].queElementArray[0].tab_eles[0].que_key,
                    "queMode":data[i].queElementArray[0].tab_eles[0].que_mode,
                    "queType":data[i].queElementArray[0].tab_eles[0].que_type,
                    "isEndNode":data[i].isEndNode,
                    "isDependent": isDependent
                };
                resultArray.push(resultObj);
            }
            var searchElement = {
                tableType : tableType,
                tableField : tableField,
                //queType : queType,
                elementId : childElementId
            };
            html = createChooseHtml(resultArray,tableField,searchElement);
            $("#searchElement_"+elementsUlId).html(html);
        }
        // var html = "";
        // html += "<li id=\"element_\"> " +
        //     "cs</li>";
        // $("#searchElement_" + elementsUlId).html(html);
    }
}