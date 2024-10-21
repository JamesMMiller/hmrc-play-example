document.getElementById("new-joke-button").addEventListener("click", function() {
    fetch("/dadjoke/new", {
        method: "GET",
        headers: {
            "Content-Type": "text/plain"
        }
    })
    .then(response => response.text())
    .then(joke => {
        document.getElementById("joke-text").textContent = joke;
    })
    .catch(error => console.error("Error fetching new joke:", error));
});
