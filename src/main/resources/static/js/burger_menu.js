function toggleMobileMenu() {
    const nav = document.getElementById('navLinks');
    const burger = document.getElementById('burgerBtn');
    nav.classList.toggle('active');
    burger.classList.toggle('open');
    document.body.style.overflow = nav.classList.contains('active') ? 'hidden' : 'auto';
}

// Чтобы функция была доступна из HTML
window.toggleMobileMenu = toggleMobileMenu;