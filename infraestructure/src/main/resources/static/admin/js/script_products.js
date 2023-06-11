

// Search handle
function handleSearchInputChange() {
    const inputElement = document.getElementById("search-box-input");
    const enteredText = inputElement.value;
    console.log(`Entered text: ${enteredText}`);
};

// Convert csv to json
async function uploadCSVFile(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.onload = (event) => {
            const csvData = event.target.result;
            const rows = csvData.split('\n');
            const headers = rows[0].split(',');
            const jsonData = [];

            for (let i = 1; i < rows.length; i++) {
                const row = rows[i].split(',');
                const jsonObject = {};

                for (let j = 0; j < headers.length; j++) {
                    jsonObject[headers[j]] = row[j];
                }

                jsonData.push(jsonObject);
            }

            resolve(jsonData);
        };

        reader.onerror = (event) => {
            reject(event.target.error);
        };

        reader.readAsText(file);
    });
};

// Handle anchor import csv click
const fileLink = document.getElementById('file-link-csv');
const fileInput = document.getElementById('file-input-csv');

fileLink.addEventListener('click', (event) => {
    event.preventDefault();
    fileInput.click();
});

fileInput.addEventListener('change', async (event) => {
    const file = event.target.files[0];

    try {
        const jsonData = await uploadCSVFile(file);
        console.log(JSON.stringify(jsonData));

        const response = await fetch('http://example.com/api/upload', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData)
        });

        if (response.ok) {
            console.log('File uploaded successfully!');
        } else {
            throw new Error('Error uploading file');
        }
    } catch (error) {
        console.error('Error:', error);
    }
});


