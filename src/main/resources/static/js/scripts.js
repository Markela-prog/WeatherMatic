const iconImg = document.getElementById('weather-icon');
const loc = document.querySelector('#location');
const tempC = document.querySelector('.c');
const tempF = document.querySelector('.f');
const desc = document.querySelector('.desc');
const sunriseDOM = document.querySelector('.sunrise');
const sunsetDOM = document.querySelector('.sunset');

function getWeather(city) {

  const base = `http://localhost:8080/weather/${city}`;

  fetch(base)
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      const { temp } = data.main;
      const place = data.name;
      const { description, icon } = data.weather[0];
      const { sunrise, sunset } = data.sys;

      const iconUrl = `https://openweathermap.org/img/wn/${icon}@2x.png`;
      const fahrenheit = (temp * 9) / 5 + 32;

      const sunriseGMT = new Date(sunrise * 1000);
      const sunsetGMT = new Date(sunset * 1000);

      // Interact with the DOM to display the data
      iconImg.src = iconUrl;
      loc.textContent = `${place}`;
      desc.textContent = `${description}`;
      tempC.textContent = `${temp.toFixed(2)} °C`;
      tempF.textContent = `${fahrenheit.toFixed(2)} °F`;
      sunriseDOM.textContent = `${sunriseGMT.toLocaleDateString()}, ${sunriseGMT.toLocaleTimeString()}`;
      sunsetDOM.textContent = `${sunsetGMT.toLocaleDateString()}, ${sunsetGMT.toLocaleTimeString()}`;
    });
}

getWeather('Vilnius');

const searchBtn = document.getElementById('searchBtn');
searchBtn.addEventListener('click', () => {
  const cityInput = document.getElementById('cityInput');
  const city = cityInput.value.trim();
  if (city !== '') {
    getWeather(city);
  }
});


