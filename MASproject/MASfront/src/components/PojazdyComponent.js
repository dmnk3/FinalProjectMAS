import { useEffect, useState } from "react";
import "../styles/PojazdyStyle.css"
import {useNavigate, useParams} from "react-router-dom";

function PojazdyComponent() {
    const navigate = useNavigate();
    const {klientId} = useParams();

    const [pojazdy, setPojazdy] = useState([]);

    const [historia, setHistoria] = useState({});

    const[brakHistoriiOkno, setBrakHistoriiOkno] = useState(false);
    const[brakPojazdowOkno, setBrakPojazdowOkno] = useState(false);

    useEffect(() => {
        fetch(`http://localhost:8080/api/klienci/${klientId}/pojazdy`)
            .then((response) => {
                if (!response.ok) throw new Error("Błąd podczas pobierania danych");
                return response.json();
            })
            .then((data) => {
                console.log("Pobrane pojazdy:", data);
                setPojazdy(data);
                if (data.length === 0) setBrakPojazdowOkno(true);
            })
    }, [klientId]);

    const fetchHistoria = (pojazdId) => {

        fetch(`http://localhost:8080/api/klienci/${klientId}/pojazdy/${pojazdId}/historia`)
            .then((response) => {
                if (!response.ok) throw new Error("Błąd podczas pobierania historii");
                return response.json();
            })
            .then((data) => {
                setHistoria((prev) => ({ ...prev, [pojazdId]: data }));
                if (data.length === 0) {
                    setBrakHistoriiOkno(true);
                }
            })
    };

    return (
        <div className="container">
            <h2>Lista pojazdów klienta</h2>
                <ul>
                    {pojazdy.map((pojazd) => {
                        const pojId = pojazd.id ?? pojazd.pojazdId;
                        return (
                            <li key={pojId}>
                                <div>
                                    <strong>Marka:</strong> {pojazd.marka}
                                    <strong>Model:</strong> {pojazd.model}
                                    <strong>Przebieg:</strong> {pojazd.przebieg} km
                                    <strong>Nr Rejestracyjny:</strong> {pojazd.nrRejestracyjny}{" "}
                                    <button onClick={() => fetchHistoria(pojId)}>Sprawdź historię serwisową</button>
                                </div>
                                {historia[pojId] && historia[pojId].length > 0 && (
                                    <ul>
                                        {historia[pojId].map((zgloszenie) => (
                                            <li key={zgloszenie.id}>
                                                <strong>Status:</strong> {zgloszenie.status} | <strong>Opis:</strong> {zgloszenie.opis}
                                            </li>
                                        ))}
                                    </ul>
                                )}
                                {historia[pojId] && historia[pojId].length === 0 && <p className={"brakPojazdu"}>Ten pojazd nie ma zapisanej historii serwisowej</p>}
                            </li>
                        );
                    })}
                </ul>
            {brakHistoriiOkno && (
                <div className="okienko">
                    <div className="okienkosrodek">
                        <h3> Brak historii serwisowej</h3>
                        <p>Ten pojazd nie posiada historii serwisowej zapisanej w bazie danych</p>
                        <div className="przyciskiOkienko">
                            <button onClick={() => navigate("/")}>Powrót do menu</button>
                            <button onClick={() => setBrakHistoriiOkno(false)}>Zmień pojazd</button>
                        </div>
                    </div>
                </div>
            )}

            {brakPojazdowOkno && (
                <div className="okienko">
                    <div className="okienkosrodek">
                        <h3> Brak pojazdów</h3>
                        <p>Nie posiadasz jeszcze żadnego pojazdu w systemie.</p>
                        <div className="przyciskiOkienko">
                            <button onClick={() => navigate("/")}>Powrót do menu</button>
                            <button onClick={() => navigate("/")}>Dodaj pojazd</button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}

export default PojazdyComponent;
