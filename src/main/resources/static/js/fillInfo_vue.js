function createTextObject(label_text, need, placeholder) {
    this.type = "text_input";
    this.label_text = label_text;
    this.need = need;
    this.bindData = "";
    this.placeholder = placeholder;
    this.color = "normal";
};
function createSelectObject(label_text, need, choices) {
    this.type = "select_input";
    this.label_text = label_text;
    this.need = need;
    this.choices = choices;
    this.bindData = choices[0];
    this.color = "normal";
};
function createRadioObject(label_text, need, radioName, radioText, radioValue) {
    this.type =  "radio_input";
    this.label_text = label_text;
    this.need = need;
    this.radioName = radioName;
    this.radioText = radioText;
    this.radioValue = radioValue;
    this.bindData = "";
    this.color = "normal";
};
var basic_info = new Vue({
    el: "#basic-info",
    data: {
        normal_label: 'normal',
        high_light_label: 'high_light',
        info_item_list: {
            "name": new createTextObject("公司名称", true, ""),
            'engName': new createTextObject("公司英文名称", false, ""),
            "telNum": new createTextObject("电话号码", true, ""),
            "faxNum": new createTextObject("传真号码", false, ""),
            "emailAddress": new createTextObject("电子邮箱", true, ""),
            "credit": new createSelectObject(
                "证件类型", true, ["贷款卡"]
            ),
            "certificateType": new createTextObject("证件号码", true, ""),
            "cardStatus": new createSelectObject("证件状态", true, ["有效", "失效"]),
            "cardExpireDate": new createTextObject("证件失效日期", false, "YYYY/MM/DD"),
            "cardAnnualCheckTime": new createTextObject("证件最新年检日期", false, "YYYY/MM/DD"),
            "isValid": new  createRadioObject(
                "是否有效", true, "isValid", {
                    "true": "是",
                    "false": "否"
                }, 
                {
                    "true": "true",
                    "false": "false"
                }
            ),
            'approvalNumber': new createTextObject("成立批准文号", true, ""),
            'registerAddr': new createTextObject("注册地址", true, ""),
            'organizationForm': new createSelectObject("组织形式", true, ['独资企业', '合资企业']),
            'delegatePerson': new createTextObject("法定代表人", true, ""),
            'isLegalPersonQualification': new createRadioObject(
                "是否法人资格", true, 'isLegalPersonQualification', {
                    "true": "是",
                    "false": "否",
                }, 
                {
                    "true": "true",
                    "false": "false",
                }
            ),
            "hasDirectorate": new createRadioObject(
                "是否有董事会", true, "hasDirectorate", {
                    "true": "是",
                    "false": "否",
                },
                {
                    "true": "true",
                    "false": "false",
                }
            ),
            "registeredCapitalCurr": new createSelectObject("注册资本币种", "true", ["美元", "人民币", "欧元"]),
            "paidinCapitalCurr": new createSelectObject("实收资本币种", "true", ["美元", "人民币", "欧元"]),
            "isSMEnterpriseEngineering": new createRadioObject(
                "是否中小企业工程", true, "isSMEnterpriseEngineering", {
                    "true": "是",
                    "false": "否",
                },
                {
                    "true": "true",
                    "false": "false",
                }
            ),
            "isHighTechEnterprise": new createRadioObject(
                "是否高新企业", true, "isHighTechEnterprise", {
                    "true": "是",
                    "false": "否",
                },
                {
                    "true": "true",
                    "false": "false",
                }
            ),
            "isListedCompany": new createRadioObject(
                "是否上市企业", true, "isListedCompany", {
                    "true": "是",
                    "false": "否",
                },
                {
                    "true": "true",
                    "false": "false",
                }
            ),
            "industryType": new createSelectObject("行业类型", "true", ["农业", "教育", "医疗", "商务"]),
            "financialStatementType": new createSelectObject("财务报表类型", "true", ["基本报表", "其他报表"]),
            "economicType": new createSelectObject("经济类型", "true", ["国有经济", "私有经济", "其他经济类型"]),
            "financialStatementSubmissionType": new createSelectObject("财务报表提交方式", "true", ["在线", "柜台", "其他"]),
            "openingLicenseNumber": new createTextObject("开户许可证号", true, ""),
            "enterpriseSubjection": new createSelectObject("企业隶属", true, ["中央直属", "省级直属", "市级直属", "无"]),
            "legalPersonCertificateType": new createSelectObject("法人证件类型", true, ["身份证", "护照", "港澳通行证"]),
            "enterpriseScale": new createSelectObject("企业规模", true, ["特大型", "大型", "中小型"]),
            "registeredCapital": new createTextObject("企业注册资本", true, ""),
            "hasImportAndExportQualification": new createRadioObject(
                "是否有进出口资格", true, "hasImportAndExportQualification", {
                    "true": "是",
                    "false": "否",
                },
                {
                    "true": "true",
                    "false": "false",
                }
            )

        },
        str_left:[
        'name', 'engName', 'telNum', 'faxNum',  'emailAddress', 'credit', 'certificateType', 'cardStatus', 'cardExpireDate', 'cardAnnualCheckTime', 'isValid'
        ],
        str_right: [
        'approvalNumber', "registerAddr", 'organizationForm', 'delegatePerson', 'isLegalPersonQualification', 'hasDirectorate', 'registeredCapitalCurr', 'paidinCapitalCurr', 'isSMEnterpriseEngineering', 'isHighTechEnterprise', 'isListedCompany', 'industryType', 'financialStatementType', 'economicType', 'financialStatementSubmissionType', 'openingLicenseNumber', 'enterpriseSubjection', 'legalPersonCertificateType', 'enterpriseScale', 'registeredCapital', 'hasImportAndExportQualification'
        ],
        status: window.companyStatus,
        show_more: false,
    },
    methods: {
        showMore: function() {
            this.show = true;
        },
        submitInfo() {
            isFinished = true;
            dataInfo = new Object();
            for (var key in this.info_item_list) {
                if (this.info_item_list[key].need == true && this.info_item_list[key].bindData == "") {
                    this.info_item_list[key].color = 'hight_light';
                    isFinished = false;
                } else {
                    dataInfo[key] = this.info_item_list[key].bindData;
                }
            }
            if (!isFinished) {
                return;
            }
            $.ajax({
                url: "/user/company/authorize",
                data: dataInfo,
                type: "POST",
                async: false,
                success: function(returnData) {
                    if (returnData.status != null && returnData != "") {
                        if (returnData.status.toLowerCase() == 'ok') {
                            location.reload();
                        }
                    }
                }
            });
        },
        isNormal: function(obj) {
            if (obj.color == 'normal') {
                return true;
            } else {
                return false;
            }
        }
    },
    computed: {
    }
});