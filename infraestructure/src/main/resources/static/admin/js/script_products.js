
// Convert csv to json
function uploadCSVFile(file) {
    // Create a FileReader instance
    const reader = new FileReader();

    // Define a promise to handle the file reading and conversion
    const filePromise = new Promise((resolve, reject) => {
        // Set up the onload event handler
        reader.onload = function (event) {
            // Get the CSV data
            const csvData = event.target.result;
            // Split the CSV data into rows
            const rows = csvData.split('\n');

            // Extract the header row
            const headers = rows[0].split(',');

            // Initialize an array to hold the JSON objects
            const jsonData = [];

            // Iterate over the remaining rows
            for (let i = 1; i < rows.length; i++) {
                const row = rows[i].split(',');
                const jsonObject = {};

                // Create a JSON object using the header row as keys
                for (let j = 0; j < headers.length; j++) {
                    jsonObject[headers[j]] = row[j];
                }

                // Add the JSON object to the array
                jsonData.push(jsonObject);
            }

            // Resolve the promise with the JSON data
            resolve(jsonData);
        };

        // Set up the onerror event handler
        reader.onerror = function (event) {
            // Reject the promise with the error message
            reject(event.target.error);
        };
    });

    // Read the file as text
    reader.readAsText(file);

    // Return the promise
    return filePromise;
}

// Handle anchor import csv click
const fileLink = document.getElementById('file-link-csv');
const fileInput = document.getElementById('file-input-csv');
fileLink.addEventListener('click', function (event) {
    event.preventDefault();
    fileInput.click();
});
fileInput.addEventListener('change', function (event) {
    const file = event.target.files[0];

    uploadCSVFile(file)
        .then((jsonData) => {
            console.log(JSON.stringify(jsonData))
            // Send the JSON data to the server
            fetch('http://example.com/api/upload', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(jsonData)
            })
                .then(response => {
                    if (response.ok) {
                        console.log('File uploaded successfully!');
                    } else {
                        throw new Error('Error uploading file');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        })
        .catch(error => {
            console.error('Error reading file:', error);
        });
});
