import '../styles/HeaderStyle.css'

function HeaderComponent() {
    return (
        <header className="top-section">
            <h1 className="salon"><a href="http://localhost:3000/">Salon Samochodowy</a></h1>
            <div className="circle"></div>
        </header>
    )
}

export default HeaderComponent;