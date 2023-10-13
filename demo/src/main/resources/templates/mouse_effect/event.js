
const createCursor = (x,y) =>{
    const cursor = document.createElement(`div`)
    cursor.className = "cursor"
    cursor.style.left = `${x}px`
    cursor.style.top = `${y}px`
    return cursor
}
window.addEventListener(`click`,event =>{
    console.log(event)
    const cursor = createCursor(event.pageX, event.pageY)
    document.body.append(cursor)
    cursorRemove(cursor)
})

const cursorRemove = cursor =>{
    const timeout = setTimeout(() =>{
        cursor.remove();
        clearTimeout(timeout)
    },500)
}