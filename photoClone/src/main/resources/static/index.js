const submit = document.getElementById('upload-button');
const input = document.getElementById('fileupload');


    submit.addEventListener('click', async (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append('data', input.files[0]);
         await fetch('http://localhost:8080/photos', {
          method: 'POST',
          body: formData,
        })
    })