var productId;
var imagesProductFile;
var data_submit;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
const selectOptionRootCategory = document.getElementById('select-option-root-category');
// Add event listener for change event
selectOptionRootCategory.addEventListener('change', async function() {
    // Get the selected option value
    const selectedValue = selectOptionRootCategory.value;

    // Perform actions based on the selected value
    if (selectedValue === '') {
        // Option "Danh mục" is selected
        console.log("Please select a category");
    } else {
        // Option with a value is selected
        console.log("Selected category ID:", selectedValue);
        var parentCategory = await getAllByParentId(selectedValue);
        replaceSelectOptionParentCategory(parentCategory);
    }
});

const selectOptionParentCategory = document.getElementById('select-option-parent-category');
// Add event listener for change event
selectOptionParentCategory.addEventListener('change', async function() {
    // Get the selected option value
    const selectedValue = selectOptionParentCategory.value;

    // Perform actions based on the selected value
    if (selectedValue === '') {
        // Option "Danh mục" is selected
        console.log("Please select a category");
    } else {
        // Option with a value is selected
        console.log("Selected category ID:", selectedValue);
        var productCategory = await getAllByParentId(selectedValue);
        console.log(productCategory);
        replaceSelectOptionProductCategory(productCategory);
    }
});

const selectOptionProductCategory = document.getElementById('select-option-product-category');
// Add event listener for change event
selectOptionProductCategory.addEventListener('change', async function() {
    // Get the selected option value
    const selectedValue = selectOptionProductCategory.value;

    // Perform actions based on the selected value
    if (selectedValue === '') {
        // Option "Danh mục" is selected
        console.log("Please select a category");
    } else {
        // Option with a value is selected
        console.log("Selected category ID:", selectedValue);
        productId = selectedValue;
    }
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
function replaceSelectOptionParentCategory(listParentCategory){

    var divSelectOptionParent = document.getElementById('select-option-parent-category');
    divSelectOptionParent.innerHTML = ''; // Clear previous HTML content
    var html = ` <option value="" disabled selected>Nhóm loại</option>`;

    listParentCategory.forEach(function (category){
        html += `<option  value="${category.id}">${category.name}</option>`;
    })
    divSelectOptionParent.innerHTML = html;
    console.log(listParentCategory);
}

function replaceSelectOptionProductCategory(listProductCategory){

    var divSelectOptionParent = document.getElementById('select-option-product-category');
    divSelectOptionParent.innerHTML = ''; // Clear previous HTML content
    var html = ` <option value="" disabled selected>Loại sản phẩm</option>`;

    listProductCategory.forEach(function (category){
        html += `<option  value="${category.id}">${category.name}</option>`;
    })
    divSelectOptionParent.innerHTML = html;
    console.log(listProductCategory);
}
async function getAllByParentId(pId) {
    try {
        const response = await fetch(`/admin/category/api/getAllByParentId?parentId=${pId}`);
        const data = await response.json();
        return data;
    } catch (error) {
        // Handle any errors that occur during the fetch request
        console.error('Error:', error);
        return []; // Return an empty array or any default value as needed
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Get the file input element
const fileInputImages = document.getElementById('upload-images-product');

// Add event listener for change event
fileInputImages.addEventListener('change', function(event) {
    // Get the selected files
    const selectedFiles = event.target.files;

    // Perform actions with the selected files
    for (let i = 0; i < selectedFiles.length; i++) {
        const file = selectedFiles[i];
        console.log('Selected file:', file.name);
        // Perform additional actions with each file, such as previewing or uploading
    }
    imagesProductFile = selectedFiles;
});


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Get a reference to the form element

addFormListen();
function addFormListen(){
    const form = document.getElementById('form-new-product');

    if(form){
        // Add an event listener to the form's submit event
        form.addEventListener('submit', submitForm);
    }
    else
    {
        console.log("Form element not found");
    }
}

// Function to handle form submission
function submitForm(event) {
    event.preventDefault(); // Prevent the default form submission

    // Get a reference to the form element
    const form = document.getElementById('form-new-product');

    // Create a new FormData object and pass the form element to it
    const formData = new FormData(form);
   console.log(formData);
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Search handle
function handleSearchInputChange() {
    const inputElement = document.getElementById("search-box-input");
    const enteredText = inputElement.value;
    console.log(`Entered text: ${enteredText}`);
};

// Get the file csv1 input element
const fileInput = document.getElementById('formFileCsv');

// Add an event listener to the file input element
if (fileInput) {
    fileInput.addEventListener('change', handleFileUpload);
} else {
    console.error("File input element not found!");
}

async function handleFileUpload(event) {
    if (event.target && event.target.files.length > 0) {
        const file = event.target.files[0]; // Get the selected file
        let mainSheetData;
        if (file) {
            // Read the file contents
            const reader = new FileReader();

            reader.onload = function (e) {
                const data = new Uint8Array(e.target.result);
                const workbook = XLSX.read(data, { type: 'array' });

                // Get the first sheet name
                const sheetName = workbook.SheetNames[0];

                // Get the worksheet by name
                const worksheet = workbook.Sheets[sheetName];

                // Convert worksheet to JSON
                const jsonData = XLSX.utils.sheet_to_json(worksheet, { header: 1 });
                var header = jsonData[0];
                // Remove the header row from the JSON data
                jsonData.shift();

                // Convert JSON data to an array of objects with field names
                var jsonArray = [];
                jsonData.forEach(function (row) {
                    var obj = {};
                    row.forEach(function (cell, index) {
                        var headerField = header[index];
                            obj[headerField] = cell;
                    });
                    jsonArray.push(obj);
                });




                // Save the data in a variable or use it as needed
                mainSheetData = jsonArray;
                console.log(mainSheetData)
                appendTableDisplayCsv(mainSheetData);

            };

            await reader.readAsArrayBuffer(file);
        }


    }

}


async function appendTableDisplayCsv(mainSheetData){

    const data = mainSheetData;
    data_submit = JSON.stringify(data);
    console.log(data_submit)
    // Append the HTML code to the table-csv-display div
    var tableDisplayDiv = document.getElementById('table-csv-display');
    var html = `
                    <div class="table-responsive text-nowrap">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Category Id</th>
                                    <th>Images</th>
                                    <th>Discount</th>
                                    <th>Price</th>
                                    <th>Des</th>
                                    <th>Quantity</th>
                                    <th>OutDate</th>
                                </tr>
                            </thead>
                            <tbody>         
                                ${data.slice(0,10).map(item => `
                                    <tr>
                                        <td>
                                            <i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.name}</strong>
                                        </td>
                                       <td>${item.productCategoryId}</td>
                                       <td>${item.descriptionImages}</td>
                                       <td>${item.discount}</td>
                                       <td>${item.price}</td>
                                       <td>${item.description}</td>
                                       <td>${item.quantity}</td>
                                       <td>${item.outDate}</td>
                                    </tr>
                                `).join('')}
                            </tbody>
                        </table>
                    </div>
                `;
    tableDisplayDiv.innerHTML = html;

    const modalFooter = document.getElementById('modal-footer-csv');
    var html2= `
                        <button type="button" id="btn-cancel-csv" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                            Huỷ
                        </button>
                        <button type="submit" id="btn-submit-csv" onclick="uploadingCsv()"  class="btn btn-primary">Lưu</button>
                        
                        <div id="spinner-submit-csv" class="visually-hidden spinner-border spinner-border-sm text-secondary" role="status">
                        
                        </div>
        `;
    console.log(typeof data_submit);
    modalFooter.innerHTML = html2;


}

async function uploadingCsv() {

    const parsedData = JSON.parse(data_submit);

    const url = '/admin/product/api/uploadProduct';
    const requestBody = data_submit;
    showLoadingIndicator();
    await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: requestBody,
    })
        .then(response => response.json())
        .then(data => {
            // Handle the response data
            console.log('Response:', data);
            if(data.length !== 0)
            {

                Swal.fire({
                    title: 'Thành công',
                    text: 'Tải lên thành công, có ' +data.length.toString()+' sản phẩm tải lên thất bại',
                    icon: 'success',
                    confirmButtonText: 'Ok',
                    didClose: () => {
                        window.location.reload();
                    }
                })
            }
            else if(data.length === 0)
                Swal.fire({
                    title: 'Thành công',
                    text: 'Tải lên thành công toàn bộ',
                    icon: 'success',
                    confirmButtonText: 'Ok',
                    didClose: () => {
                        window.location.reload();
                    }
                })
        })
        .catch(error => {
            // Handle any errors
            console.error('Error:', error);
            alert("Loi roi");
        });
    hideLoadingIndicator();

}
function showLoadingIndicator() {
    // Show loading indicator logic
    // You can display a spinner or any other visual indication of loading
    // For example, adding a CSS class to show the loading spinner
    document.getElementById('spinner-submit-csv').classList.remove('visually-hidden');
    document.getElementById('btn-submit-csv').classList.add('visually-hidden');
}
async function hideLoadingIndicator() {
    // Hide loading indicator logic
    // You can hide the spinner or remove the visual indication of loading
    // For example, removing the CSS class that shows the loading spinner
    document.getElementById('spinner-submit-csv').classList.add('visually-hidden');
    document.getElementById('btn-submit-csv').classList.remove('visually-hidden');
    document.getElementById('btn-cancel-csv').click();
}







