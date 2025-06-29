// JavaScript for nav scroll and active link handling

const navbar = document.getElementById('navbar');
const navLinks = document.querySelectorAll('.nav-links a');
const sections = document.querySelectorAll('header, section');

// Change navbar style on scroll
window.addEventListener('scroll', () => {
  // Add or remove .scrolled class based on scroll position
  navbar.classList.toggle('scrolled', window.scrollY > 50);

  // Highlight nav item based on current section
  let currentSection = '';
  sections.forEach(section => {
    const sectionTop = section.offsetTop - 120;
    const sectionHeight = section.clientHeight;
    if (window.scrollY >= sectionTop && window.scrollY < sectionTop + sectionHeight) {
      currentSection = section.getAttribute('id');
    }
  });

  navLinks.forEach(link => {
    link.classList.remove('active');
    if (link.getAttribute('href') === `#${currentSection}`) {
      link.classList.add('active');
    }
  });
});
