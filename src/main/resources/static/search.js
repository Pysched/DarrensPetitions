document.addEventListener('DOMContentLoaded', function () {
    var searchInput = document.getElementById("searchInput");
    var searchResults = document.getElementById("searchResults");

    // Add event listener for input changes in the search field
    searchInput.addEventListener("input", function () {

        // Remove leading/trailing white spaces
        var searchTerm = this.value.trim();

        // If search term is empty, fetch search results
        // PArse it as json
        fetch(`/search/${searchTerm.toLowerCase()}`)
            .then(response => response.json())
            .then(data => {
                // clear any exisitng search results
                searchResults.innerHTML = "";

                // Create and append the li's to the ul
                data.forEach(function (petition) {
                    var listItem = document.createElement("a");
                    listItem.className = "list-group-item list-group-item-action";
                    listItem.href = "/result/" + petition.petitionTitle;
                    listItem.innerHTML = petition.petitionTitle;
                    // append the created list to the search results container
                    searchResults.appendChild(listItem);
                });
            });
    });
});