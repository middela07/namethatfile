const folderInput = document.getElementById('folderInput');

folderInput.addEventListener('change', (event) => {
    const selectedFolder = event.target.files[0];

    if (selectedFolder) {
        const folderPath = selectedFolder.webkitRelativePath || selectedFolder.mozFullPath || selectedFolder.name;

        // Prepare the data to send
        const formData = new FormData();
        formData.append('folderPath', folderPath);

        // Send the folderPath to your Java application
        fetch('http://0.0.0.0:8000/home.html', {
            method: 'POST',
            body: formData,
        })
        .then((response) => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Folder upload failed.');
            }
        })
        .then((data) => {
            console.log(data); // Handle the response from your Java application
        })
        .catch((error) => {
            console.error(error);
        });
    }
});
