// Get a reference to the host element
const host = document.querySelector("#shadowHost");

// Create a shadow root
const shadowRoot = host.attachShadow({ mode: "open" });

// Create the shadow element

// Define the style for the shadow element
const style = document.createElement("style");
style.textContent = `
  div {
    width: 200px;
    height: 200px;
    background-color: gray;
    margin: auto;
    width: 50%;
    border: 3px solid blue;
  }
`;
// Attach the style and the shadow element to the shadow root
shadowRoot.appendChild(style);

const shadowElement1 = document.createElement("div");
shadowElement1.textContent = "Shadow Element";
shadowRoot.appendChild(shadowElement1);

const shadowElement2= document.createElement("p");
shadowElement2.textContent = "Paragraph inside shadow element";
shadowElement1.appendChild(shadowElement2);

const button = document.createElement("button");
button.innerText = "Button";
shadowElement1.appendChild(button);

