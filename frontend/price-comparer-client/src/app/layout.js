import "./globals.css";
import NavBar from "../components/navBar";

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className="px-4">
        <div className="flex">
          <NavBar />
        </div>
        <main className="md:container md:mx-auto">{children}</main>
      </body>
    </html>
  );
}
