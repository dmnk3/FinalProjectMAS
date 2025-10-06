import '../styles/MainMenuStyle.css'

import {useNavigate} from "react-router-dom";

function MainMenu() {
    const navigate = useNavigate();
    return (
        <div className="divmain">
                <>
                    <h1 className="h1mainmenu">Witaj! Co dzisiaj chcesz zrobić? </h1>
                    <div className="button-grid">
                        <button className="grid-button">
                            Umów się na oglądanie pojazdu
                        </button>

                        <button className="grid-button">
                            Wyświetl dostępne ogłoszenia
                        </button>

                        <button className="grid-button" onClick={() => navigate("/klient/4")}>
                            Wyświetl posiadane pojazdy
                        </button>

                        <button className="grid-button">
                            Dodaj swój pojazd
                        </button>

                        <button className="grid-button">
                            Umów się na serwis
                        </button>

                        <button className="grid-button">
                            Dodaj samochód do listy życzeń
                        </button>
                    </div>
                </>
        </div>
    )
}

export default MainMenu;