 async function replaceParentCategory(objId, name) {

    alert(objId);
    await localStorage.setItem('rootCategorySelected',objId.toString());

    setParentIdToPCategory(objId);
    setParentnameToPCategory(name);
}

function setParentIdToPCategory(parentId){
    const ParentId2 = document.getElementById("modalAddCategoryParentId2");
    ParentId2.value = parentId;
};

 function setParentnameToPCategory(parentName){
     const ParentName2 = document.getElementById("modalAddCategoryParentName2");
     ParentName2.value = parentName;
 };
