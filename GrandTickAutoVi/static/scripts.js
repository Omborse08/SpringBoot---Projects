let countdownInterval;
let clockInterval;
let globalSavedAuthHeader = "";
let isAdminAuthenticated = false;

// TARGET SAVED METRICS FOR CONTINUOUS TICKING
let currentServerTimeParsed = null;
let currentActiveZoneId = "Asia/Kolkata"; // Default fallback tracking

// 1. FIXED: DYNAMIC ZONE CLOCK ENGINE (Using Intl to preserve target country's view)
function startZoneClock() {
    if (clockInterval) clearInterval(clockInterval);

    clockInterval = setInterval(() => {
        if (currentServerTimeParsed) {
            // Advance time by 1 second locally to simulate dynamic clock
            currentServerTimeParsed.setSeconds(currentServerTimeParsed.getSeconds() + 1);

            // Map location naming to official IANA Zone Names for rendering
            let ianaZone = "UTC";
            if (currentActiveZoneId === "mumbai") ianaZone = "Asia/Kolkata";
            else if (currentActiveZoneId === "new_york") ianaZone = "America/New_York";
            else if (currentActiveZoneId === "london") ianaZone = "Europe/London";

            // Options declaration to enforce selected country timezone formatting rules explicitly
            const options = {
                timeZone: ianaZone,
                hour: '2-digit',
                minute: '2-digit',
                second: '2-digit',
                hour12: true
            };

            // Formatting output relative to target IANA location safely
            const formatter = new Intl.DateTimeFormat('en-US', options);
            document.getElementById("server-right-time").innerText = formatter.format(currentServerTimeParsed);
        }
    }, 1000);
}

// 2. FETCH COUNTDOWN & TIMEZONE METRICS
async function initCountdown(location = "mumbai") {
    currentActiveZoneId = location; // Track currently selected tab id

    // UI Button Active Styling
    document.querySelectorAll('.location-btn').forEach(btn => btn.classList.remove('active'));
    const activeBtn = document.getElementById(`btn-${location}`);
    if (activeBtn) activeBtn.classList.add('active');

    try {
        const response = await fetch(`${BASE_URL}/countdown?location=${location}`);
        if (!response.ok) throw new Error("Fetch failed");
        const data = await response.json();

        document.getElementById("countdown-message").innerText = data.countdown.message;

        // Base parse tracking 
        currentServerTimeParsed = new Date(data.rightTime);

        // Trigger optimized multi-zone clock tick engine immediately
        startZoneClock();

        // Sync Target Countdown Clock Logic
        let totalRemainingMs = (
            (data.countdown.days * 24 * 60 * 60 * 1000) +
            (data.countdown.hours * 60 * 60 * 1000) +
            (data.countdown.minute * 60 * 1000) +
            (data.countdown.seconds * 1000)
        );

        let targetTime = Date.now() + totalRemainingMs;

        if (countdownInterval) clearInterval(countdownInterval);

        countdownInterval = setInterval(() => {
            const difference = targetTime - Date.now();

            if (difference <= 0) {
                document.getElementById("timer").innerHTML = "<h2 style='color:#66fcf1;'>LAUNCHED WORLDWIDE! 🚀</h2>";
                clearInterval(countdownInterval);
                return;
            }

            const days = Math.floor(difference / (1000 * 60 * 60 * 24));
            const hours = Math.floor((difference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            const minutes = Math.floor((difference % (1000 * 60 * 60)) / (1000 * 60));
            const seconds = Math.floor((difference % (1000 * 60)) / 1000);

            document.getElementById("days").innerText = String(days).padStart(2, '0');
            document.getElementById("hours").innerText = String(hours).padStart(2, '0');
            document.getElementById("minutes").innerText = String(minutes).padStart(2, '0');
            document.getElementById("seconds").innerText = String(seconds).padStart(2, '0');
        }, 1000);

    } catch (error) {
        console.error(error);
        document.getElementById("countdown-message").innerText = "Sync Failed.";
    }
}