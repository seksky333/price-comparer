 import "./globals.css";

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className="px-4">
        <header>Header</header>
        return <h1 className="text-3xl font-bold underline">Hello, Next.js!</h1>
        <main>{children}</main>
        <footer>Footer</footer>
      </body>
    </html>
  );
}
