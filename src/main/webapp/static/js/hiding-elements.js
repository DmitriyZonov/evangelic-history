const btn = document.getElementById('hide-btn');
const collapsibleItems = document.querySelectorAll('.item.collapsible');
let expanded = false;

// Инициализация: сворачиваем все блоки
collapsibleItems.forEach(el => {
    el.style.maxHeight = '0px';
    el.style.opacity = '0';
    el.style.paddingTop = '0px';
    el.style.paddingBottom = '0px';
    el.style.marginBottom = '0px';
    el.classList.remove('expanded');
});

function expandItem(el) {
    el.classList.add('expanded');
    el.style.maxHeight = '226px';
    el.style.opacity = '1';
    el.style.marginBottom = '40px';
}

function collapseItem(el) {
    const currentHeight = el.scrollHeight;
    el.style.maxHeight = currentHeight + 'px'; // start from current height
    el.offsetHeight; // force reflow
    el.style.maxHeight = '0px';
    el.style.opacity = '0';
    el.style.paddingTop = '0px';
    el.style.paddingBottom = '0px';
    el.style.marginBottom = '0px';
    el.classList.remove('expanded');
}

btn.addEventListener('click', () => {
    expanded = !expanded;
    btn.textContent = expanded ? 'Скрыть' : 'Показать все';
    collapsibleItems.forEach(el => expanded ? expandItem(el) : collapseItem(el));

    if(expanded) {
        const lastItem = document.querySelector('.hide-btn');
        if (lastItem) {
            setTimeout(() => {
                lastItem.scrollIntoView({behavior: 'smooth', block: 'end'});
            }, 450);
        }
    } else {
        const firstItem = document.querySelector('.events-announcements-title');
        if (firstItem) {
            setTimeout(() => {
                firstItem.scrollIntoView({behavior: 'smooth', block: 'start'});
                }, 300);
        }
    }
});
