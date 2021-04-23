import {Link} from 'react-router-dom';

const Navbar = () => {
    return (
        <nav className="navbar">
            <h1>Pinpoint Personal Plates</h1>
            <div className="links">
                <Link to="/">Home</Link>
                <Link to="/search">Search Plates</Link>
                <Link to="/create">Create a Plate</Link>
            </div>
        </nav>
    );
};

export default Navbar;
