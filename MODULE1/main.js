// 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
  alert("Page fully loaded!");
});

// 2. Syntax, Data Types, and Operators
const eventName = "Music Concert";
const eventDate = "2025-06-15";
let availableSeats = 10;

const eventInfo = `Event: ${eventName}, Date: ${eventDate}, Seats: ${availableSeats}`;
console.log(eventInfo);

// 3. Conditionals, Loops, and Error Handling
const events = [
  { name: "Music Concert", date: "2025-06-15", category: "music", seats: 10 },
  { name: "Art Exhibition", date: "2024-05-01", category: "art", seats: 0 },
  { name: "Sports Day", date: "2025-07-10", category: "sports", seats: 15 },
];

function isUpcoming(event) {
  const today = new Date().toISOString().split("T")[0];
  return event.date > today && event.seats > 0;
}

events.forEach((evt) => {
  if (isUpcoming(evt)) {
    console.log(`Upcoming Event: ${evt.name}`);
  }
});

function registerEvent(eventName) {
  try {
    const event = events.find((e) => e.name === eventName);
    if (!event) throw new Error("Event not found");
    if (event.seats <= 0) throw new Error("No seats available");

    event.seats--;
    alert(
      `Successfully registered for ${event.name}. Remaining seats: ${event.seats}`
    );
  } catch (error) {
    alert(`Registration failed: ${error.message}`);
  }
}

// 4. Functions, Scope, Closures, Higher-Order Functions
function addEvent(name, date, category, seats) {
  events.push({ name, date, category, seats });
}

function registerUser(eventName) {
  registerEvent(eventName);
}

function filterEventsByCategory(category) {
  return events.filter((e) => e.category === category);
}

// Closure to track total registrations per category
function categoryRegistrationTracker() {
  const counts = {};
  return function (category) {
    counts[category] = (counts[category] || 0) + 1;
    return counts[category];
  };
}
const trackCategory = categoryRegistrationTracker();

// 5. Objects and Prototypes
function Event(name, date, category, seats) {
  this.name = name;
  this.date = date;
  this.category = category;
  this.seats = seats;
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const musicEvent = new Event("Jazz Night", "2025-08-20", "music", 30);
console.log(Object.entries(musicEvent));

// 6. Arrays and Methods
events.push(new Event("Cooking Workshop", "2025-09-01", "food", 20));
const musicEvents = events.filter((e) => e.category === "music");
const displayCards = events.map((e) => `📅 ${e.name} on ${e.date}`);

console.log(displayCards);

// 7. DOM Manipulation
const eventSection = document.querySelector("#events");

function renderEvents() {
  events.forEach((e) => {
    if (!isUpcoming(e)) return;

    const div = document.createElement("div");
    div.className = "eventCard";
    div.innerHTML = `
      <h3>${e.name}</h3>
      <p>Date: ${e.date}</p>
      <p>Category: ${e.category}</p>
      <p>Seats Left: ${e.seats}</p>
      <button onclick="registerEvent('${e.name}')">Register</button>
    `;
    eventSection.appendChild(div);
  });
}

renderEvents();

// 8. Event Handling
document.querySelector("#eventType").addEventListener("change", function () {
  const category = this.value;
  const filtered = filterEventsByCategory(category);
  alert(`Filtered ${filtered.length} ${category} event(s)`);
});

document.addEventListener("keydown", (e) => {
  if (e.key === "Enter") {
    alert("Pressed Enter! Consider adding search logic.");
  }
});

// 9. Async JS, Promises, Async/Await
const mockFetchEvents = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve([{ name: "Yoga Retreat", date: "2025-10-10", seats: 12 }]);
    }, 1000);
  });
};

function loadRemoteEvents() {
  const loading = document.createElement("p");
  loading.textContent = "Loading remote events...";
  eventSection.appendChild(loading);

  mockFetchEvents()
    .then((data) => {
      data.forEach((e) => {
        const div = document.createElement("div");
        div.className = "eventCard";
        div.innerHTML = `<h3>${e.name}</h3><p>${e.date}</p>`;
        eventSection.appendChild(div);
      });
    })
    .catch((err) => console.error("Failed to fetch:", err))
    .finally(() => loading.remove());
}

loadRemoteEvents();

// 10. Modern JavaScript Features
function greet(name = "Guest") {
  console.log(`Hello, ${name}!`);
}
greet();

const [firstEvent] = events;
const { name: firstName, date: firstDate } = firstEvent;
console.log(`First event: ${firstName} on ${firstDate}`);

const clonedEvents = [...events];

// 11. Working with Forms
document.querySelector("#contactForm").addEventListener("submit", (e) => {
  e.preventDefault();

  const form = e.target;
  const name = form.elements["name"].value.trim();
  const email = form.elements["email"].value.trim();
  const message = form.elements["message"].value.trim();

  const output = document.querySelector("#formOutput");

  if (!name || !email || !message) {
    output.textContent = "Please fill all required fields.";
    output.style.color = "red";
    return;
  }

  output.textContent = `Thank you, ${name}! We'll get back to you.`;
  output.style.color = "green";
});

// 12. AJAX & Fetch API (Simulated)
function sendRegistration(name, email) {
  const data = { name, email };

  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    body: JSON.stringify(data),
    headers: {
      "Content-type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((json) => {
      alert("Registration sent!");
      console.log(json);
    })
    .catch((err) => console.error("Error submitting:", err));
}

// Geolocation
document.querySelector("#findEvents").addEventListener("click", () => {
  const output = document.querySelector("#locationOutput");

  if (!navigator.geolocation) {
    output.textContent = "Geolocation not supported.";
    return;
  }

  navigator.geolocation.getCurrentPosition(
    (position) => {
      output.textContent = `Lat: ${position.coords.latitude}, Long: ${position.coords.longitude}`;
    },
    (error) => {
      output.textContent = `Error getting location: ${error.message}`;
    }
  );
});

// Video Playback Interaction
const video = document.querySelector("#promoVideo");
const videoMsg = document.querySelector("#videoMessage");

video.addEventListener("play", () => {
  videoMsg.textContent = "Video is now playing...";
});
video.addEventListener("pause", () => {
  videoMsg.textContent = "Video has been paused.";
});
video.addEventListener("ended", () => {
  videoMsg.textContent = "Thanks for watching!";
});
